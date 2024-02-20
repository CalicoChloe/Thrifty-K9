package com.example.pricingpal.model.datatransferobjects

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrganizationDTO (
    @SerialName("organizationName")
    val organizationName: String,
)