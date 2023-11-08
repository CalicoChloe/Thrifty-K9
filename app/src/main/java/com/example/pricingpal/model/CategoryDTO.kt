package com.example.pricingpal.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Class: CategoryDTO
 * @author Connor Murdock
 * @version 1
 * @written 11/08/2023
 * This data class acts as an interface to transfer data of our Category objects to and from the database.
 */
@Serializable
data class CategoryDTO(
    @SerialName("category_id")
    val categoryId: Int,
    @SerialName("category")
    val categoryName: String
)
