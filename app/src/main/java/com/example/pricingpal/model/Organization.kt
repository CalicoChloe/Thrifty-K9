package com.example.pricingpal.model

/**
 * Class: Organization
 * @author Abdoulie NJie
 * @version 1
 * @written 3/06/2024
 * @property organizationID the ID of an organization.
 * @property ownerID the ID of an owner of an organization.
 * @property organizationName the name of an organization.
 * This data class acts as an interface to transfer data of our Organization objects to and from the database.
 *
*/
data class Organization(val organizationID: String, val ownerID: String,val organizationName: String)