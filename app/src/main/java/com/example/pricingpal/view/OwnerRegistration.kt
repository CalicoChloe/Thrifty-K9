package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pricingpal.PricingPalAppBar
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.utilites.ErrorMessages.EMAIL_ALREADY_TAKEN
import com.example.pricingpal.utilites.ErrorMessages.ORGANIZATION_NAME_ALREADY_TAKEN
import com.example.pricingpal.viewmodel.SignUpViewModel


/**
 * Function: Owner Registeration Header
 * @author Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up a scaffold with top bar for the owner registration screen.
 * Users will see a display of the back arrow that will allow the user to navigate back to the choose registration screen.
 * Below the bar will show the rest of the content of the owner registration screen.
 *
 * NOTE: I have the scaffold set up this way, so it matches the design from figma, so please don't change it.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OwnerRegisterationHeader(
    navController: NavController,
    windowSize: WindowSize,
    isOwner: Boolean
) {
    // will scale the space of the card
    val cardSpacer by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 25 else 40) }
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
                    PricingPalAppBar(
                        navigateUp = { navController.navigateUp() },
                        canNavigateBack = navController.previousBackStackEntry != null
                    )
                },
                content = { padding ->
                    ownerRegistration(padding, windowSize, isOwner)
                },

                // this needs to stay this color so the scaffold can have the lines beneath it.
                containerColor = Persian_indigo
            )
        }
    }
}

/**
 * Function: Owner Registration
 * @author: Shianne Lesure
 * @author: Abdoulie NJie
 *
 * @param paddingValues aligns the content with top app bar
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 * @param isOwner is a boolean used to classify the user that is signing up through this screen is an owner
 *
 * This function sets up the rest of the content of the Owner Registration screen.
 * Users will see some text-fields asking for an organization name, full name, email and password as well as message telling them
 * if their password is too weak and a dialog telling them what they need to do to fix it.
 * Below that will be the list of buttons the user can navigate to.
 */
@Composable
fun ownerRegistration(
    paddingValues: PaddingValues,
    windowSize: WindowSize,
    isOwner: Boolean,
    signUpViewModel: SignUpViewModel = hiltViewModel()
) {
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 50 else 60) }
    Column(
        modifier = Modifier
            .padding(paddingValues)
            // this is here so the line above the pricing pal logo
            .padding(top = 4.dp)
            .background(color = Periwinkle)
            .verticalScroll(rememberScrollState()), // allows for the items in the column to scroll
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // holds the pricing pal logo
        innerPricingBar()
        if(windowSize.width == WindowType.Compact){
            Text(
                textAlign = TextAlign.Center,
                text = "Owner \n\n Registration",
                fontSize = textSize.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        } else {
            Text(
                textAlign = TextAlign.Center,
                text = "Owner Registration",
                fontSize = textSize.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        // holds the full name text-field
        ownerFullNameInput(signUpViewModel)
        Spacer(modifier = Modifier.height(25.dp))

        // holds the organization text-field
        ownerOrganizationInput(signUpViewModel)
        Spacer(modifier = Modifier.height(25.dp))

        // holds the email text-field
        emailInputOwner(signUpViewModel)
        Spacer(modifier = Modifier.height(25.dp))

        // holds the password text-field
        passwordInputOwner(signUpViewModel)
        Spacer(modifier = Modifier.height(25.dp))


        // Sign up Button
        signSnackBar(windowSize, isOwner)
        Spacer(modifier = Modifier.height(20.dp))
    }
}


/**
 * Function: Owner Organization Input
 * @author: Shianne Lesure
 * @author: Abdoulie NJie
 * @version 2
 * @written 4/19/2024
 *
 * This function sets up the text-field for the user to be able to put in their organization to be able to
 * sign up. This is a requirement for the user to be able to navigate to the Upload screen.
 */
@Composable
fun ownerOrganizationInput(signUpViewModel: SignUpViewModel) {
    //variable that stores the error message that will be displayed based on the user's input of the organization name
    var errorMessage by remember { mutableStateOf("") }
    //variable used to reference the values stored in the organizationState
    val organizationsNames = signUpViewModel.organizationsNames.collectAsState().value

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                // conditional statement used to determine the border color
                color = if (signUpViewModel.organizationName
                        .collectAsState()
                        .value.isBlank() ||
                    isOrganizationNameTaken(
                        signUpViewModel.organizationName
                            .collectAsState()
                            .value, organizationsNames
                    )
                ) Color.Red else Color.Transparent,
                width = 2.dp,
                shape = RectangleShape
            )
            .horizontalScroll(rememberScrollState()),
        value = signUpViewModel.organizationName
            .collectAsState()
            .value,
        onValueChange = {
            signUpViewModel.onOrganizationChange(it) // will take in the input from the user
            // if statement that determines if the error message needs to be display
            errorMessage =
                if (isOrganizationNameTaken(
                        signUpViewModel.organizationName.value.trimEnd(),
                        organizationsNames
                    )
                ) {
                    ORGANIZATION_NAME_ALREADY_TAKEN
                } else {
                    ""
                }
        }, // Reset error message when user modifies the input
        textStyle = TextStyle.Default.copy(fontSize = 20.sp, color = Color.Black),
        placeholder = { Text("Enter organization", fontSize = 20.sp, color = Color.Black) },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_add_business_24),
                contentDescription = "Business Icon",
                tint =  Color.Black
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Anti_flash_white,
            unfocusedContainerColor = Anti_flash_white,
            unfocusedIndicatorColor = Anti_flash_white,
            focusedIndicatorColor = Persian_indigo,

        ),
        shape = RectangleShape,
    )
    /** I did this in replacement of the supporting text*/
    // This message is below the text-field
    // The message can change if their input is wrong
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 50.dp)
    ) {
        Text(
            text = "*required",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 50.dp)
        ) {
            // Display error message if organization name is already taken
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 20.sp,
            )
        }
    }
}

/**
 * Function isOrganizationNameTake
 * @author: Abdoulie NJie
 * @version 1
 * @written 3/20/2024
 * This function is used search through a list of organization names and determine if the user's input matches
 * a record already stored in the list
 */
fun isOrganizationNameTaken(
    name: String,
    organizations: List<String>?,
): Boolean {
    organizations?.forEach { organization ->
        if (organization.equals(name, ignoreCase = true) || organization.equals("$name.*\\s$", ignoreCase = true)) {
            return true
        }
    }
    return false
}

/**
 * Function: Owner Organization Input
 * @author: Shianne Lesure
 * @author: Abdoulie NJie
 * @version 2
 * @written 4/19/2024
 * This function sets up the text-field for the user to be able to put in their full name to be able to
 * sign up. This is a requirement for the user to be able to navigate to the Upload screen.
 */
@Composable
fun ownerFullNameInput(signUpViewModel: SignUpViewModel) {
    var fullName =
        signUpViewModel.fullName.collectAsState(initial = "") // variable that holds a default state of text-field
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                // conditional statement used to determine the border color
                color = if (fullName.value.isBlank()) Color.Red else Color.Transparent,
                width = 2.dp,
                shape = RectangleShape
            )
            .horizontalScroll(rememberScrollState()),
        value = fullName.value,
        onValueChange = { signUpViewModel.onNameChange(it) }, // will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp , color = Color.Black),
        placeholder = { Text("Enter your full name", fontSize = 20.sp,color = Color.Black) },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_drive_file_rename_outline_24),
                contentDescription = "Pencil Icon",
                tint = Color.Black
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Anti_flash_white,
            unfocusedContainerColor = Anti_flash_white,
            unfocusedIndicatorColor = Anti_flash_white,
            focusedIndicatorColor = Persian_indigo
        ),
        shape = RectangleShape,
    )
    Row(
        horizontalArrangement = Arrangement.Start,
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
 * Function: Email Input Owner
 * @author: Shianne Lesure
 * @author: Abdoulie NJie
 * @version 2
 * @written 4/19/2024
 * This function sets up the text-field for the user to be able to put in their email to be able to
 * sign up. This is a requirement for the user to be able to navigate to the Upload screen.
 */
@Composable
fun emailInputOwner(signUpViewModel: SignUpViewModel) {
    var errorMessage by remember { mutableStateOf("") }
    val users = signUpViewModel.usersEmails.collectAsState().value
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                // conditional statement used to determine the border color
                color = if (signUpViewModel.email
                        .collectAsState().value
                        .isBlank() ||
                    isEmailTaken(signUpViewModel.email.collectAsState().value, users)
                ) Color.Red else Color.Transparent,
                width = 2.dp,
                shape = RectangleShape
            )
            .horizontalScroll(rememberScrollState()),
        value = signUpViewModel.email.collectAsState().value,
        onValueChange = {
            signUpViewModel.onEmailChange(it) // will take in the input from the user
            // if statement that determines if the error message needs to be display
            errorMessage = if (isEmailTaken(signUpViewModel.email.value.trimEnd(), users)) {
                EMAIL_ALREADY_TAKEN
            } else {
                ""
            }
        }, // Reset error message when user modifies the input
        textStyle = TextStyle.Default.copy(fontSize = 20.sp, color = Color.Black),
        placeholder = { Text("Enter email", fontSize = 20.sp, color = Color.Black) },
        /** The support text will not work if you have a modifier.*/
        leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon", tint = Color.Black) },
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
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 50.dp)
    ) {
        Text(
            text = "*required",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 50.dp)
        ) {
            // Display error message if organization name is already taken
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 20.sp,
            )
        }
    }
}


/**
 * Function isEmailTaken
 * @author: Abdoulie NJie
 * @version 1
 * @written 3/20/2024
 * This function is used search through a list of emails and determine if the user's input matches
 * a record already stored in the list
 */
fun isEmailTaken(
    email: String,
    users: List<String>?,
): Boolean {
    users?.forEach { usersEmails ->
        if (usersEmails.equals(email, ignoreCase = true) || usersEmails.equals("$email.*\\s$", ignoreCase = true) ) {
            return true
        }
    }
    return false
}

/**
 * Function: Password Input Owner
 * @author: Shianne Lesure
 * @author Abdoulie NJie
 * @version 2
 *
 * This function set up the text-field for the user to be able to put in their password to be able to
 * sign up. This is a requirement for the user to be able to navigate to the Upload screen.
 */
@Composable
fun passwordInputOwner(signUpViewModel: SignUpViewModel) {
    var password =
        signUpViewModel.password.collectAsState(initial = "")// variable that holds a default state of text-field
        var hidePass by remember { mutableStateOf(true) } // variable that holds a default state of the password being hidden

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                // conditional statement used to determine the border color
                color = if (password.value.isBlank()) Color.Red else Color.Transparent,
                width = 2.dp,
                shape = RectangleShape
            )
            .horizontalScroll(rememberScrollState()),
        value = password.value,
        onValueChange = { signUpViewModel.onPasswordChange(it) }, // will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp,color = Color.Black),
        placeholder = { Text("Enter password", fontSize = 20.sp, color = Color.Black) },
        visualTransformation = if(hidePass) PasswordVisualTransformation() else VisualTransformation.None,// makes the password not visible to the user
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // This will show the black dots instead of letters
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock Icon", tint = Color.Black) },
        trailingIcon = {
            //When clicked, it should switch the hidden icon to the eye icon
            IconButton(onClick = { hidePass = !hidePass }){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.eye ),
                    contentDescription = "Lock Icon",
                    tint = Color.Black
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Anti_flash_white,
            unfocusedContainerColor = Anti_flash_white,
            unfocusedIndicatorColor = Anti_flash_white,
            focusedIndicatorColor = Persian_indigo
        ),
        shape = RectangleShape,
    )
    // This message is below the text-field
    // The message can change if their input is wrong
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 50.dp)
    ) {
        Text(
            text = "*required\nmust contain at least 9 characters",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
    }
}


/**
 * Function: Sign Snack Bar
 * @author: Shianne Lesure
 * @author: Abdoulie NJie
 * @version 2
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display a snack-bar when the sign up button is clicked. The snack bar will show a
 * message verifying the user is login.
 *
 * NOTE: This isn't really how snack-bars are made. I tried to go the route it is usually made, but
 * for some reason I couldn't get it quite right. If I can get the originally way to work, I will change
 * it, but this should be fine for now.
 */
@Composable
fun signSnackBar(windowSize: WindowSize, isOwner: Boolean) {
    val signUpViewModel: SignUpViewModel = hiltViewModel()
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 110 else 120) }
    // will scale the height of the snack-bar
    val snackBarHeight by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 70 else 80) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 35 else 40) }
    // will scale the size of the snack-bar padding
    val snackBarPaddingTop by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 15 else 20) }
    // will scale the size of the snack-bar padding
    val snackBarPadding by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 15 else 30) }
    // variable used to reference the message produced from the sign up process
    val message by signUpViewModel.message.collectAsState(initial = "")
    // variable used to reference the values stored in the organizationNames
    val organizationsNames = signUpViewModel.organizationsNames.collectAsState().value
    // variable used to reference the values stored in the userEmails
    val users = signUpViewModel.usersEmails.collectAsState().value
    // a variable that determines if the snack-bar will be displayed or not
    var showSnackBar by remember { mutableStateOf(false) }

    ElevatedButton(
        onClick = {
            if(!isOrganizationNameTaken(signUpViewModel.organizationName.value.trimEnd(), organizationsNames)
                && !isEmailTaken(signUpViewModel.email.value.trimEnd(), users)) {
                signUpViewModel.onSignUp(isOwner)
                showSnackBar = true
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
            text = "Sign Up",
            fontSize = textSize.sp,
            color = Color.Black,
        )
    }
    // the snack-bar will display an success or error message when the submit button is clicked
    if (showSnackBar) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(snackBarHeight.dp)
                .padding(start = 25.dp, end = 25.dp)
                .border(2.dp, color = Persian_indigo)
                .shadow(5.dp, shape = RectangleShape)
                .background(color = Anti_flash_white, shape = RectangleShape),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                textAlign = TextAlign.Start,
                text = message,
                modifier = Modifier
                    .padding(top = snackBarPaddingTop.dp, start = snackBarPadding.dp)
                    .horizontalScroll(rememberScrollState()),

                fontSize = 25.sp,
                color = Color.Black,

            )
        }
    }
}
