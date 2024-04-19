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


@AndroidEntryPoint
class DeepLinkHandlerActivity : ComponentActivity() {

    @Inject
    lateinit var supabaseClient: SupabaseClient

    private lateinit var callback: (String, String) -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uri: Uri? = intent.data
            supabaseClient.handleDeeplinks(intent = intent,
                onSessionSuccess = { userSession ->
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
                            email = emailState.value,
                            createdAt = createdAtState.value,
                            onClick = { navigateToMainApp() }
                        )

                    }
                }
            }

    }

    private fun navigateToMainApp() {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        startActivity(intent)
    }
}

