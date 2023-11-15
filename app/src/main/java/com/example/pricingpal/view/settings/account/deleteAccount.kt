package com.example.pricingpal.view.settings.account

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Persian_indigo

@Composable
fun accountDialog() {
    var showDialog by remember { mutableStateOf(false) }
    Column {
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
                text = "Delete Account",
                fontSize = 40.sp,
                color = Color.Black,
            )
        }
    }
    if (showDialog) {
        Dialog(onDismissRequest = {showDialog = false}) {
            // Custom shape, background, and layout for the dialog
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
                    Text(text = "By, deleting this account," +
                            "you will also be deleting the organization." +
                            "Do you still wish to delete this account?",
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ){
                        deleteAccountDialog()
                        Spacer(modifier = Modifier.width(25.dp))
                        Button(
                            onClick = { showDialog = false },
                            shape =  RectangleShape,
                            colors = ButtonDefaults.buttonColors(Cornflower_blue),
                            elevation = ButtonDefaults.buttonElevation(8.dp),
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .border(3.dp, color = Persian_indigo),
                        ) {
                            Text("No",
                                fontSize = 25.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun deleteAccountDialog() {
    var showDialog by remember { mutableStateOf(false) }
    Column {
        ElevatedButton(
            onClick = { showDialog = true },
            elevation = ButtonDefaults.buttonElevation(8.dp),
            shape =  RectangleShape,
            colors = ButtonDefaults.buttonColors(Cornflower_blue),
            modifier = Modifier
                .padding(top = 16.dp)
                .border(3.dp, color = Persian_indigo),

            ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Yes",
                fontSize = 25.sp,
                color = Color.Black,
            )
        }
    }
    if (showDialog) {
        Dialog(onDismissRequest = {showDialog = false}) {
            // Custom shape, background, and layout for the dialog
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
                    Text(text = "Your account has been deleted.",
                        fontSize = 40.sp,
                        color = Color.Black,
                    )
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