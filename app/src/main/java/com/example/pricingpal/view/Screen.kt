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
    object CategoryList : Screen("category_list")
    object ItemList : Screen("item_list")
    object SearchResults : Screen("search_results")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}
