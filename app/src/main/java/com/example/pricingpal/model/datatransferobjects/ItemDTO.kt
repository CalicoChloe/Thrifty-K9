package com.example.pricingpal.model.datatransferobjects

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
    @SerialName("id")
    val itemId: Int,
    @SerialName("name")
    val itemName: String,
    @SerialName("price")
    val price: Float,
    @SerialName("category_id")
    val categoryId: Int,
    @SerialName("organization_name")
    val organizationName: String
)


