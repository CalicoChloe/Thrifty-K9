package com.example.pricingpal.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.Item
import com.example.pricingpal.model.Organization
import com.example.pricingpal.model.datatransferobjects.CategoryDTO
import com.example.pricingpal.model.datatransferobjects.ItemDTO
import com.example.pricingpal.model.repositories.CategoryRepository
import com.example.pricingpal.model.repositories.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Class: CategoryViewModel
 * @author Connor Murdock
 * @version 1
 * @written 11/20/2023
 * This class is the ViewModel for the Category/Item information. When this ViewModel is created it will connect
 * to the SupaBase database, pull the list of Categories and Items, then turn them into usable data for the app.
 */
@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository,
    private val itemRepository: ItemRepository,
) : ViewModel() {
    private lateinit var organizationViewModel: OrganizationViewModel

    fun initializeOrganizationViewModel(fragment: Fragment) {
        organizationViewModel = ViewModelProvider(fragment).get(OrganizationViewModel::class.java)
    }

    //lists of the categories from the database that are updated by the ViewModel
    private val _categoryList = MutableStateFlow<List<Category>?>(listOf())
    val categoryList: Flow<List<Category>?> = _categoryList

    //When this ViewModel is created, call these two functions
    init {
        initializeOrganizationViewModel(fragment = Fragment())
        observeSelectedOrganization()
        //observeCategories()
    }

    private fun observeSelectedOrganization() {
        viewModelScope.launch {
            organizationViewModel.selectedOrganization
                .filterNotNull() // Ignore null values
                .distinctUntilChanged() // Emit only distinct organization objects
                .collect { organization ->
                    // Fetch categories for the selected organization
                    getCategories(organization)
                }
        }
    }

    //Gets the list of categories from the database and emits it to _categoryList
    fun getCategories(organization: Organization) {
        viewModelScope.launch {
            val categories2 = categoryRepository.getCategories(organization)
            _categoryList.emit(categories2?.map { it -> it.asDomainModel() })
        }
    }

    //When the Category data from the database is pulled, this function will translate it from a DTO to the real object
    suspend fun CategoryDTO.asDomainModel(): Category {
        return Category(
            categoryId = this.categoryId,
            categoryName = this.categoryName,
            items = getItems(this.categoryId)!!
        )
    }

    //Gets the list of item from the database and returns it as an ArrayList of Items
    suspend fun getItems(categoryId: Int): ArrayList<Item>? {
        return itemRepository.getItems(categoryId)?.map { it.asDomainModel() } as ArrayList<Item>?
    }

    //When the Item data from the database is pulled, this function will translate it from a DTO to the real object
    private fun ItemDTO.asDomainModel(): Item {
        return Item(
            id = this.itemId,
            name = this.itemName,
            price = this.price.toDouble(),
            categoryId = this.categoryId,
            organizationName = this.organizationName
        )
    }
}





//IT'S A SECRET TO EVERYBODY.
//If you're reading this, don't give up! がんばれ!