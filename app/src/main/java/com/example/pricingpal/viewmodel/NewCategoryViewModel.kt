package com.example.pricingpal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.CategoryDTO
import com.example.pricingpal.model.CategoryItemRepository
import com.example.pricingpal.model.Item
import com.example.pricingpal.model.ItemDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewCategoryViewModel @Inject constructor(
    private val categoryItemRepository: CategoryItemRepository
) : ViewModel() {

    val categories = HashMap<String, Category>()

    private val _categoryList = MutableStateFlow<List<Category>?>(listOf())
    val categoryList: Flow<List<Category>?> = _categoryList

    init {
        getCategories()
        observeCategories()
    }

    fun observeCategories() {
        viewModelScope.launch {
            categoryList.collect {categoryList -> categoryList?.let {
                    populateCategories(it)
                }
            }
        }
    }

    fun populateCategories(categoryList: List<Category>) {
        for (c in categoryList) {
            categories.put(c.category, c)
        }
    }

    fun getCategories() {
        viewModelScope.launch {
            val categories2 = categoryItemRepository.getCategories()
            _categoryList.emit(categories2?.map { it -> it.asDomainModel() })
        }
    }

    private suspend fun CategoryDTO.asDomainModel(): Category {
        return Category(
            category = this.categoryName,
            item = getItems(this.categoryId)!!
        )
    }

    private suspend fun getItems(categoryId: Int): ArrayList<Item>? {
        return categoryItemRepository.getItems(categoryId)?.map { it.asDomainModel() } as ArrayList<Item>?
    }

    private fun ItemDTO.asDomainModel(): Item {
        return Item(
            category = "",
            name = this.itemName,
            price = this.price.toDouble()
        )
    }
}