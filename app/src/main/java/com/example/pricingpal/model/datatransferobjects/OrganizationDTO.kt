package com.example.pricingpal.model.datatransferobjects

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class OrganizationDTO (
    @SerialName("organization_name")
    val organizationName: String,
    @SerialName("organization_id")
    val organizationId: String,
    @SerialName("owner_id")
    val ownerId: String,
)