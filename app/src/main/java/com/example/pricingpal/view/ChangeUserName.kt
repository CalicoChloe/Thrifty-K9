package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pricingpal.R
import com.example.pricingpal.model.datatransferobjects.UserDTO
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.viewmodel.UserViewModel

/**
 * Function: Change Name Header
 * @author Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up a scaffold with top bar for the change name screen.
 * Users will see a display of the back arrow that will allow the user to navigate back to owner account page.
 * Below the bar will show the rest of the content of the change name screen.
 *
 * NOTE: I have the scaffold set up this way, so it matches the design from figma, so please don't change it.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangeNameHeader(windowSize: WindowSize){
    // will scale the space of the card
    val cardSpacer by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 25 else 40) }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Anti_flash_white
    ) {
        Image(
            //Imports image from resource folder
            painter = painterResource(id = R.drawable.paw_background),
            //description of the image for accessibility
            contentDescription = "Pictures of paws",
            //crops the image
            contentScale = ContentScale.Crop,
            // changes the opacity of the image
            alpha = 0.1F
        )
        Card(
            modifier = Modifier
                .padding(start = cardSpacer.dp, end = cardSpacer.dp)
                .fillMaxSize()
                .border(4.dp, color = Persian_indigo),
            shape = RectangleShape,
            elevation = CardDefaults.cardElevation(12.dp),
        ) {
            Scaffold(
                // creates the top app bar for the back arrow navigation
                topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Cornflower_blue,
                        ),
                        title = {
                            Text(text = "")
                        },
                        navigationIcon = {
                            IconButton(onClick = { /*TODO*/ },
                            ) {
                                Icon(imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Back arrow Button",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .size(50.dp)
                                )

                            }
                        },
                    )
                },
                content = { padding ->
                    changeName(padding, windowSize)
                },

                // this needs to stay this color so the scaffold can have the lines beneath it.
                containerColor = Persian_indigo
            )
        }
    }
}

/**
 * Function: Change Name
 * @author: Shianne Lesure
 *
 * @param paddingValues aligns the content with top app bar
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up the rest of the content of the change name screen.
 * Users will see a list of instructions with 2 text-fields explaining they need to input the old name
 * and new name which will be saved for update.
 */
@Composable
fun changeName(paddingValues: PaddingValues, windowSize: WindowSize, viewModel: UserViewModel = hiltViewModel()){
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 40 else 60) }
    // will scale the size of the text
    val instructionTextSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 25 else 30) }
    // will scale the space between the buttons
    val buttonSpacer by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 180 else 260) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            // this is here so the line above the pricing pal logo
            .padding(top = 4.dp)
            .background(color = Periwinkle),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        settingsBar(windowSize)
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            textAlign = TextAlign.Center,
            text = "Change Name",
            fontSize = textSize.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            textAlign = TextAlign.Center,
            text = "New name should be different from old name",
            fontSize = instructionTextSize.sp,
            color = Color.Black,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(50.dp))

        oldInputChangeName(viewModel)
        Spacer(modifier = Modifier.height(10.dp))
        newInputChangeName(viewModel)

        Spacer(modifier = Modifier.height(50.dp))

        saveName(windowSize,viewModel)
        Spacer(modifier = Modifier.height(buttonSpacer.dp))
    }
}

/**
 * Function: Old Input Change Name
 * @author: Shianne Lesure
 *
 * This function set up the text-field for the user to be able to input their old name.
 */
@Composable
fun oldInputChangeName(viewModel: UserViewModel){
    //var oldName by remember { mutableStateOf("") }// variable that holds a default state of text-field
    val oldName = viewModel.userName.collectAsState(initial = "")
    val user = viewModel.userData.collectAsState(initial = UserDTO)

    //viewModel.getUser(user.toString())

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp),
        value = oldName.value,
        onValueChange = {viewModel.onNameChange(it)}, // will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp) ,
        placeholder = { Text("Enter old name", fontSize = 20.sp) },
        /** The support text will not work if you have a modifier.*/
        //supportingText = { Text(text = "*required") },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Anti_flash_white,
            unfocusedContainerColor = Anti_flash_white,
            unfocusedIndicatorColor = Anti_flash_white,
            focusedIndicatorColor = Persian_indigo
        ),
        shape = RectangleShape,
    )
    /** I did this in replacement of the supporting text*/
    // This message is below the text-field
    // The message can change if their input is wrong
    Row(horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 50.dp)
    ) {
        Text(
            text = "*required",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
    }
}

/**
 * Function: New Input Change Name
 * @author: Shianne Lesure
 *
 * This function set up the text-field for the user to be able to input their new name.
 */
@Composable
fun newInputChangeName(viewModel: UserViewModel){
    //var newName by remember { mutableStateOf("") }// variable that holds a default state of text-field
    val newName = viewModel.userName.collectAsState(initial = "")
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp),
        value = newName.value,
        onValueChange = {

            viewModel.onNameChange(it)
                        }, // will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp) ,
        placeholder = { Text("Enter new name", fontSize = 20.sp) },
        /** The support text will not work if you have a modifier.*/
        //supportingText = { Text(text = "*required") },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Anti_flash_white,
            unfocusedContainerColor = Anti_flash_white,
            unfocusedIndicatorColor = Anti_flash_white,
            focusedIndicatorColor = Persian_indigo
        ),
        shape = RectangleShape,
    )
    /** I did this in replacement of the supporting text*/
    // This message is below the text-field
    // The message can change if their input is wrong
    Row(horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 50.dp)
    ) {
        Text(
            text = "*required",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
    }
}

/**
 * Function: Save Name
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display a button that will allow the user to save the updated information.
 */
@Composable
fun saveName(windowSize: WindowSize, viewModel: UserViewModel){
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 100 else 120) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 35 else 40) }
    //val userMessage = viewModel.userMessage.collectAsState("")
    val userMessage by viewModel.userMessage.collectAsState("")

    ElevatedButton( enabled = false,
        onClick = {
            viewModel.updateUser()
            if (userMessage == "Username successfully updated.") {
                //navController.navigate(Screen.UploadFormat.route)
            } else {
                userMessage == "Updated Error"
            }
        },
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Cornflower_blue),
        elevation = ButtonDefaults.buttonElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(buttonHeight.dp)
            .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
            .border(4.dp, color = Persian_indigo),

        ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Save",
            fontSize = textSize.sp,
            color = Color.Black,
        )
    }
    // make another button, and put it within a box() method. This button will hold the fail or success message.
}