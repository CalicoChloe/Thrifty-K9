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
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    /**
     * Companion
     *
     * This companion object is used to create a function called valueOf,
     *
     * @constructor Create empty Companion
     * @author Abdoulie J NJie
     */
    companion object {
        /**
         * Value of
         *
         * @param value the String value of the Screen route that is being displayed to the user
         * @return the String value of whatever Screen is being displayed
         *
         * @author Abdoulie J NJie
         */
        fun valueOf(value: String): String {
            return value
        }
    }
}
