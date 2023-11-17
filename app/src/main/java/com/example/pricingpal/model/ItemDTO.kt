package com.example.pricingpal.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Class: CategoryDTO
 * @author Connor Murdock
 * @version 1
 * @written 11/08/2023
 * This data class acts as an interface to transfer data of our Item objects to and from the database.
 */
@Serializable
data class ItemDTO(
    @SerialName("item_id")
    val itemId: Int,
    @SerialName("item")
    val itemName: String,
    @SerialName("price")
    val price: Float,
    @SerialName("category_id")
    val categoryId: Int
)
