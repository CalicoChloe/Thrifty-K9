package com.example.pricingpal.model.datatransferobjects

import com.example.pricingpal.model.UUIDSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

/**
 * Class: OrganizationDTO
 * @author Abdoulie NJie
 * @version 1
 * @written 3/06/2024
 * This data class acts as an interface to transfer data of our Organization objects to and from the database.
 */

@Serializable
data class OrganizationDTO (
    @SerialName("organization_ID")
    @Serializable(with = UUIDSerializer::class)
    val organizationID: UUID,
    @SerialName("owner_ID")
    @Serializable(with = UUIDSerializer::class)
    val ownerID: UUID,
    @SerialName("organization_Name")
    val organizationName: String,
)

