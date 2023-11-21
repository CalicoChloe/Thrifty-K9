package com.example.pricingpal.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.CategoryDTO
import com.example.pricingpal.model.CategoryItemRepository
import com.example.pricingpal.model.Item
import com.example.pricingpal.model.ItemDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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

    suspend fun populateCategories(categoryList: List<Category>) {
        for (c in categoryList) {
            c.item = getItems(c.categoryId)!!
            categories.put(c.category, c)
            Log.e("Category", c.toString())
            Log.d("HashMap", categories.toString())
        }
    }

    fun getCategories() {
        viewModelScope.launch {
            val categories2 = categoryItemRepository.getCategories()
            _categoryList.emit(categories2?.map { it -> it.asDomainModel() })
        }
    }

    private fun CategoryDTO.asDomainModel(): Category {
        return Category(
            categoryId = this.categoryId,
            category = this.categoryName,
            item = ArrayList<Item>()
        )
    }

    private suspend fun getItems(categoryId: Int): ArrayList<Item>? {
        return categoryItemRepository.getItems(categoryId)?.map { it.asDomainModel() } as ArrayList<Item>?
    }

    private fun ItemDTO.asDomainModel(): Item {
        return Item(
            category = "",
            itemName = this.itemName,
            price = this.price.toDouble(),
            categoryId = this.categoryId,
            organizationId = this.organizationId,
            itemId = this.itemId
        )
    }
}