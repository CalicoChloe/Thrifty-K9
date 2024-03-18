package com.example.pricingpal.view

/**
 * Sealed class for the navigation routes.
 *
 * This class defines various routes used for navigation.
 *
 * @property route the String value to be saved for each screen that will serve as the route address.
 *
 * @author Connor Murdock
 */
sealed class Screen(val route: String) {
    object CategoryList : Screen("Category List")
    object ItemList : Screen("Items List")
    object SearchResults : Screen("Search Results")
    object LoadingScreen : Screen("Loading Screen")
    object HomeScreen : Screen("Home Screen")
    object RegisterScreen: Screen("Register Screen")
    object LoginInScreen: Screen ("Log in Screen")
    object OrganizationList: Screen("Organization List")



    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}