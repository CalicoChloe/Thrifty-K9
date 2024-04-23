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
    object ItemList : Screen("items_list")
    object SearchResults : Screen("search_results")
    object LoadingScreen : Screen("loading_screen")
    object HomeScreen : Screen("home_screen")
    object RegisterScreen: Screen("register_screen")
    object LoginInScreen: Screen ("login_screen")
    object SignUpVerified: Screen ("sign_up_verified_screen")
    object UploadFormat: Screen("Upload Format")
    object Setting: Screen("Settings")
    object OwnerAccount: Screen("Owner Account")
    object GuestAccount: Screen("Guest Account")
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