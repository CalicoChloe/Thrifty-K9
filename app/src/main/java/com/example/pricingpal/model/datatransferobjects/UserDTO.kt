package com.example.pricingpal.model.datatransferobjects

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Class: UserDTO
 * @author Abdoulie NJie
 * @version 1
 * @written 3/06/2024
 * This data class acts as an interface to transfer data of our User objects to and from the database.
 */

@Serializable
data class UserDTO(
    @SerialName("user_id")
    @Contextual
    val userID: String,
    @SerialName("full_Name")
    val fullName: String,
    @SerialName("email")
    val email: String,
    @SerialName("organization_Name")
    val organizationName: String,
    @SerialName("is_owner")
    val isOwner: Boolean
)
