package com.example.pricingpal.model

/**
 * Class: User
 *
 * @author Abdoulie NJie
 * @author Shianne Lesure
 *
 * @written 2/26/2024
 *
 * @property userId is the UUID of the user.
 * @property fullName the name of a user.
 * @property email the email of a user.
 * @property organizationName is the name of the organization the user belongs to.
 * @property isOwner is to check if the user is an owner of the organization or a regular user.
 *
 * This class defines the category class properties.
 **/
data class User(
    val userId: String,
    val fullName: String,
    val email: String,
    val organizationName: String,
    val isOwner: Boolean
)