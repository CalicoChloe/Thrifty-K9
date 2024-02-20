package com.example.pricingpal.model.datatransferobjects

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Class: OrganizationDTO
 * @author Abdoulie NJie
 * @written 2/19/2024
 * This data class acts as an interface to transfer data of our organization objects to and from the database.
 */
@Serializable
data class OrganizationDTO (
    @SerialName("organizationName")
    val organizationName: String,
)