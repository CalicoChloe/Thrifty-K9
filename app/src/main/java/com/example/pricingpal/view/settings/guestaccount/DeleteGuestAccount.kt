package com.example.pricingpal.view.settings.guestaccount

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun deleteIconDialog(){
    var showDialog by remember { mutableStateOf(false) }// a variable that determines if the state of the dialog to be use or not
    Column {
        // Delete Icon Button
        // will send you to a dialog asking if you want to delete the guest account
        IconButton(onClick = { showDialog = true },
            modifier = Modifier
                .size(50.dp)
            ) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 10.dp)
            )
        }
    }
    if (showDialog) {// the dialog shows if send button is clicked
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
                    Text(text = "Do you want to delete this account?",
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ){
                        deleteGuestDialog() // will navigate you to another dialog box
                        Spacer(modifier = Modifier.width(25.dp))
                        //No Button
                        // will close you out the dialog box
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
fun deleteGuestDialog(){
    var showDialog by remember { mutableStateOf(false) }// a variable that determines if the state of the dialog to be use or not
    Column {
        // Yes Button
        // will send you to a dialog telling you the guest account has been deleted
        // this should be remove from the database
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
                    Text(text = "The account has been deleted.",
                        fontSize = 40.sp,
                        color = Color.Black,
                    )
                    // Close Button
                    // will close the dialog box
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