package com.example.pricingpal.model

/**
 * Class: User
 * @author Abdoulie NJie
 * @version 1
 * @written 3/06/2024
 * @property userID the ID of a user.
 * @property fullName the name of a user.
 * @property email the email of a user.
 * @property organizationName is the name of the organization the user belongs to.
 * @property isOwner is the boolean used to indicate if the user is an owner of an organization or not.
 * This data class acts as an interface to transfer data of our User objects to and from the database.
 *
 **/
data class User(val userID: String,
                val fullName: String,
                val email: String,
                val organizationName : String,
                val isOwner: Boolean)