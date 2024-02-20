package com.example.pricingpal.model.datatransferobjects

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Class: UserDTO
 * @author Abdoulie NJie
 * @written 2/19/2024
 * This data class acts as an interface to transfer data of our user objects to and from the database.
 */
@Serializable
data class UserDTO(
    @SerialName("full_name")
    val fullName: String,
    @SerialName("email")
    val email: String,
    @SerialName("organization_name")
    val organizationName: String
)
