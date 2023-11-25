package com.example.pricingpal.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.Item
import com.example.pricingpal.model.dto.CategoryDTO
import com.example.pricingpal.model.dto.ItemDTO
import com.example.pricingpal.model.repositories.CategoryRepository
import com.example.pricingpal.model.repositories.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val itemRepository: ItemRepository
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
            categoryList.collect { categoryList ->
                categoryList?.let {
                    populateCategories(it)
                }

            }
        }
    }

    fun populateCategories(categoryList: List<Category>) {
        for (c in categoryList) {
            categories.put(c.category, c)
            Log.e("Category", c.toString())
        }
    }

    fun getCategories(){
                viewModelScope.launch {
                    val categories2 = categoryRepository.getCategories()
                    _categoryList.emit(categories2?.map { it -> it.asDomainModel() })
                }
}

    suspend fun CategoryDTO.asDomainModel(): Category {
        return Category(
            category = this.categoryName,
            item = getItems(this.categoryId)!!
        )
    }

    suspend fun getItems(categoryId: Int): ArrayList<Item>? {
        return itemRepository.getItems(categoryId)?.map { it.asDomainModel() } as ArrayList<Item>?
    }

    private fun ItemDTO.asDomainModel(): Item {
        return Item(
            id = this.itemId,
            name = this.itemName,
            price = this.price.toDouble(),
            categoryId = this.categoryId,
            organizationId = this.organizationId.toString()

        )
    }
}