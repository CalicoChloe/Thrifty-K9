package com.example.pricingpal.view.editinglist.makelist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.ui.theme.Uranian_Blue
import com.example.pricingpal.view.repetitivefunctions.settingNavigationBar

@Composable
fun addImage(){
    Card(
        modifier = Modifier
            .padding(start = 40.dp, end = 40.dp)
            .fillMaxSize()
            .border(4.dp, color = Persian_indigo),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(containerColor = Periwinkle)
    ) {

        // Holds the navigation of the back arrow and setting
        // Navigates to the Edit List Screen
        settingNavigationBar()

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())// Allows for the column to scroll
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                textAlign = TextAlign.Center,
                text = "Category Image",
                fontSize = 60.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(30.dp))
            addImageButton() // adds Image file from user's device to Screen
            Spacer(modifier = Modifier.height(50.dp))
            for(i in 1..2) {
                imageName() // will show the name of the Image file
            }
            Spacer(modifier = Modifier.height(50.dp))
            uploadImageButton()// upload Image to category
            Spacer(modifier = Modifier.height(140.dp))
        }
    }
}

/** The add Image Button
 * once clicked, will show the Image file name underneath*/
@Composable
fun addImageButton(){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp)
            .height(300.dp)
            .background(color = Color.White, shape = RectangleShape),
    ) {
        /** When the image is being loaded, it has to be a certain size or the app will crash.
         * An error can them above the button saying,
         * "Your file is too big. Image needs to be no bigger than 430 X 300."*/
        ElevatedButton(
            onClick = { /*TODO*/ },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Cornflower_blue),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .padding(start = 70.dp, top = 15.dp, end = 70.dp, bottom = 15.dp)
                .height(30.dp)
                .padding(100.dp)
                .border(4.dp, color = Persian_indigo),

            ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Add Image",
                fontSize = 30.sp,
                color = Color.Black,
            )

        }
    }
}


@Composable
fun imageName(){
    Card(
        modifier = Modifier
            .padding(15.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                border = BorderStroke(4.dp, color = Persian_indigo),
                shape = RectangleShape
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(color = Uranian_Blue, shape = RectangleShape)
                .fillMaxWidth()
                .height(80.dp)
        )
        {
            Text(
                text = "Image Name", // will be the name of the Image file
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

            //Delete Button
            // Will allow for you to remove the Image file
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 10.dp, top = 5.dp)
                )
            }

        }
    }
}

/** will upload the Image file to the category
 * will navigate to the Edit list Screen*/
@Composable
fun uploadImageButton(){
    ElevatedButton(
        onClick = { /*TODO*/ },
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Cornflower_blue),
        elevation = ButtonDefaults.buttonElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(start = 50.dp, top = 15.dp, end = 50.dp, bottom = 15.dp)
            .border(4.dp, color = Persian_indigo),

        ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Upload Image",
            fontSize = 40.sp,
            color = Color.Black,
        )
    }
}