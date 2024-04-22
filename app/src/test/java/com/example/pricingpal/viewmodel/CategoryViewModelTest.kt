package com.example.pricingpal.viewmodel

import com.example.pricingpal.model.datatransferobjects.CategoryDTO
import com.example.pricingpal.model.repositories.CategoryRepository
import com.example.pricingpal.model.repositories.ItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

import kotlin.collections.ArrayList

import org.junit.Assert.assertEquals
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

@RunWith(MockitoJUnitRunner::class)
class CategoryViewModelTest {

    @Mock
    private lateinit var mockCategoryRepository: CategoryRepository

    @Mock
    private lateinit var mockItemRepository: ItemRepository

    private lateinit var categoryViewModel: CategoryViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        categoryViewModel = CategoryViewModel(mockCategoryRepository, mockItemRepository)
    }

    @Test
    suspend fun testGetCategories() {
        // Given
        val categoryDTOList = ArrayList<CategoryDTO>()
        categoryDTOList.add(CategoryDTO(1, "Category 1"))
        categoryDTOList.add(CategoryDTO(2, "Category 2"))

        // When
        `when`(mockCategoryRepository.getCategories()).thenReturn(categoryDTOList)

        // Then
        categoryViewModel.getCategories()

        // Verify
        verify(mockCategoryRepository).getCategories()
    }

    // Add more test cases as needed...
}
