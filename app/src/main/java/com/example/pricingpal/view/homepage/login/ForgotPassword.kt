package com.example.pricingpal.view.homepage.login


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.view.repetitivefunctions.arrowNavigationBar
import com.example.pricingpal.view.repetitivefunctions.emailInput
import com.example.pricingpal.view.repetitivefunctions.innerPricingBar

@Composable
fun forgotPassword() {
    Card(
        modifier = Modifier
            .padding(start = 40.dp, end = 40.dp)
            .fillMaxSize()
            .border(4.dp, color = Persian_indigo),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(containerColor = Periwinkle)
    ) {
        // Holds the navigation of the back arrow
        // Navigates to the login Screen
        arrowNavigationBar()

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()), // allows for the items in the column to scroll
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            innerPricingBar() // holds the pricing pal logo
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                textAlign = TextAlign.Center,
                text = "Forgot Password?",
                fontSize = 60.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                textAlign = TextAlign.Center,
                text = "Enter registered email for reset password",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(50.dp))
            emailInput() // holds email text-field

            Spacer(modifier = Modifier.height(50.dp))
            forgotPasswordDialog() // holds the send button that will take you to the forgot password dialog
            Spacer(modifier = Modifier.height(140.dp))
        }
    }
}


/** This functionality hold the dialog for when the user press the button send,
 * it will show them the message "Email was sent"*/
@Composable
fun forgotPasswordDialog() {
    // a variable that determines if the state of the dialog to be use or not
    var showDialog by remember { mutableStateOf(false) }
    Column {

        // Send Button
        //this will allow for the dialog to be open
        // this button will also send a verification link to the user's email
    ElevatedButton(
        onClick = { showDialog = true },
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Cornflower_blue),
        elevation = ButtonDefaults.buttonElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
            .border(4.dp, color = Persian_indigo),

        ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Send",
            fontSize = 40.sp,
            color = Color.Black,
        )
    }
}
    // the dialog shows if send button is clicked
    if (showDialog) {
        Dialog(onDismissRequest = {showDialog = false}) {

            //Hold makes up the dialog box
            Surface(
                shape = RectangleShape,
                color = Color.White,
                modifier = Modifier
                    .shadow(elevation = 8.dp, RectangleShape)
                    .border(2.dp, color = Color.Black),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Holds the message that will be shown in dialog
                    Text(text = "Email was sent",
                        fontSize = 35.sp,
                        color = Color.Black,
                    )

                    //Close button
                    // will exit the dialog
                    Button(
                        onClick = { showDialog = false },
                        shape =  RectangleShape,
                        colors = ButtonDefaults.buttonColors(Cornflower_blue),
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .border(3.dp, color = Persian_indigo),
                    ) {
                        Text("Close",
                            fontSize = 25.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}


