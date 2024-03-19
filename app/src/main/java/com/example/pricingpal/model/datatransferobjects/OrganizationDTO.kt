package com.example.pricingpal.model.datatransferobjects

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrganizationDTO (
    @SerialName("organization_ID")
    @Contextual
    val organizationId: String,
    @SerialName("owner_ID")
    @Contextual
    val ownerId: String,
    @SerialName("organization_Name")
    val organizationName: String

)