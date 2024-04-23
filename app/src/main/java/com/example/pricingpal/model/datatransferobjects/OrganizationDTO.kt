package com.example.pricingpal.model.datatransferobjects

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Class: OrganizationDTO
 * @author Abdoulie NJie
 * @version 1
 * @written 3/06/2024
 * This data class acts as an interface to transfer data of our Organization objects to and from the database.
 */

@Serializable
data class OrganizationDTO (
    @SerialName("organization_id")
    @Contextual
    val organizationID: String,
    @SerialName("owner_id")
    @Contextual
    val ownerID: String,
    @SerialName("organization_name")
    val organizationName: String
)

