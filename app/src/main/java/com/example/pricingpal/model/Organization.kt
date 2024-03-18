package com.example.pricingpal.model

import java.util.UUID

/**
 * Data class for a category
 *
 * This class defines the category class properties.
 *
 * @property organizationName is the name of the organization the user belongs to.
 *
 * @Abdoulie NJie
 **/
data class Organization(val organizationId: String, val organizationName: String, val ownerId: String)