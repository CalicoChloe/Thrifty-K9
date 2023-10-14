package com.example.pricingpal.view

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
