package com.example.pricingpal.model.datatransferobjects

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Class: UserDTO
 *
 * @author Abdoulie NJie
 * @author Shianne Lesure
 *
 * @written 2/19/2024
 *
 * @property userId is the UUID of the user.
 * @property fullName the name of a user.
 * @property email the email of a user.
 * @property organizationName is the name of the organization the user belongs to.
 * @property isOwner is to check if the user is an owner of the organization or a regular user.
 *
 * This data class acts as an interface to transfer data of our user objects to and from the database.
 */
@Serializable
data class UserDTO(
    @SerialName("user_id")
    //@Contextual val userID: UUID,
    // contextual is use as a fallback for the UUID because a serializer has not been found with UUID
    //@Contextual val userId: String,
    val userId: String,
    @SerialName("full_name")
    val fullName: String,
    @SerialName("email")
    val email: String,
    @SerialName("organization_name")
    val organizationName: String,
    @SerialName("is_owner")
    val isOwner: Boolean
)
