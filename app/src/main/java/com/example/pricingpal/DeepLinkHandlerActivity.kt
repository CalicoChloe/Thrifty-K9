package com.example.pricingpal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.pricingpal.ui.theme.PricingpalTheme
import com.example.pricingpal.view.SignUpVerified
import dagger.hilt.android.AndroidEntryPoint
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.gotrue.handleDeeplinks
import javax.inject.Inject

/**
 * @author: Abdoulie NJie
 * @version: 1
 * @written 4/19/2024
 * This file is used to handle the deep link functionality of the app link that is associated with
 * the sign up verification process of the application.
 */

@AndroidEntryPoint
class DeepLinkHandlerActivity : ComponentActivity() {

    @Inject
    // variable used to reference a Supabase client
    lateinit var supabaseClient: SupabaseClient
    // variable used to reference user's information generated during session
    private lateinit var callback: (String, String) -> Unit
    /**
     * Function onCreate
     * @author: Abdoulie NJie
     * @version: 1
     * @written 4/19/2024
     *
     * This function is used to override the onCreate method of the app's activity lifecycle to
     * handle the intent provided by the user's interaction during the sign up process.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retrieve the URI data from the intent that started the activity.
        val uri: Uri? = intent.data
        // If statement that checks if the URI is not null and if it has a specific host and path.
        if (uri != null && uri.host == "pricingpal.info" && uri.path == "/sign_up_verified_screen") {
            // call to supabase client to handle the deep link
            supabaseClient.handleDeeplinks(intent = intent,
                onSessionSuccess = { userSession ->
                    // log message that indicate the sign-up was successful
                    Log.d("SIGN UP", "Sign up successfully with user info: ${userSession.user}")
                    userSession.user?.apply {
                        callback(email ?: "", createdAt.toString())
                    }
                })
            setContent {
                val navController = rememberNavController()
                val emailState = remember { mutableStateOf("") }
                val createdAtState = remember { mutableStateOf("") }
                LaunchedEffect(Unit) {
                    callback = { email, created ->
                        emailState.value = email
                        createdAtState.value = created
                    }
                }
                PricingpalTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background

                    ) {
                        SignUpVerified(
                            modifier = Modifier.padding(20.dp),
                            navController = navController,
                            onClick = { navigateToMainApp() }
                        )

                    }
                }
            }

        }
    }
    /**
     * Function navigateToMainApp
     * @author: Abdoulie NJie
     * @version: 1
     * @written 4/19/2024
     * This function is used to redirect the user to the main page of the application.
     */
    private fun navigateToMainApp() {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        startActivity(intent)
    }
}

