package com.example.pricingpal.model.datatransferobjects

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserDTO(
    @SerialName("fullName")
    val fullName: String,
    @SerialName("email")
    val email: String,
    @SerialName("organizationName")
    val organizationName: String,
)