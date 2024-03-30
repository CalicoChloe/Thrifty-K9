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
    object UploadFormat: Screen("Upload Format")
    object Setting: Screen("Settings")
    object OwnerAccount: Screen("Owner Account")
    object ChangeOrganization: Screen("Change Organization")
    object ChangeUsername: Screen("Change Username")
    object ChangeEmail: Screen("Change Email")
    object ChangePassword: Screen("Change Password")



    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}