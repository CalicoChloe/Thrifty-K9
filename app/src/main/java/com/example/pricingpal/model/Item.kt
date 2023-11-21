package com.example.pricingpal.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * Data class for an item.
 *
 * This class defines the item class and its properties.
 *
 * @property category the category of this item.
 * @property name the name of this item.
 * @property price the price of this item.
 *
 * @author Chloe Jackson
 */

data class Item(
    val itemId: Int,
    val itemName: String,
    val price: Double,
    val categoryId: Int,
    val organizationId: UUID,
    val category: String
)
