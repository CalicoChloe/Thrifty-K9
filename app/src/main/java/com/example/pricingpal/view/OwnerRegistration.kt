package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
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
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pricingpal.PricingPalAppBar
import com.example.pricingpal.R
import com.example.pricingpal.model.Organization
import com.example.pricingpal.model.User
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
fun ownerRegistration(paddingValues: PaddingValues, windowSize: WindowSize, isOwner: Boolean) {
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 50 else 60) }
    val signUpViewModel: SignUpViewModel = hiltViewModel()
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
        Text(
            textAlign = TextAlign.Center,
            text = "Owner Registration",
            fontSize = textSize.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(25.dp))

        // holds the full name text-field
        ownerFullNameInput()
        Spacer(modifier = Modifier.height(25.dp))

        // holds the organization text-field
        ownerOrganizationInput(signUpViewModel)
        Spacer(modifier = Modifier.height(25.dp))

        // holds the email text-field
        emailInputOwner(signUpViewModel)
        Spacer(modifier = Modifier.height(25.dp))

        // holds the password text-field
        passwordInputOwner()
        Spacer(modifier = Modifier.height(25.dp))

        // check whether password is strong or weak
        passwordStrengthOwner(windowSize)
        Spacer(modifier = Modifier.height(20.dp))

        // Sign up Button
        signSnackBar(windowSize, isOwner)
        Spacer(modifier = Modifier.height(20.dp))
    }
}


/**
 * Function: Owner Organization Input
 * @author: Shianne Lesure
 *
 * This function sets up the text-field for the user to be able to put in their organization to be able to
 * sign up. This is a requirement for the user to be able to navigate to the Upload screen.
 */
@Composable
fun ownerOrganizationInput(signUpViewModel: SignUpViewModel) {
    //variable that holds a default state of text-field
    var organizationName by remember { mutableStateOf("") }
    //variable that stores the error message that will be displayed based on the user's input of the organization name
    var errorMessage by remember { mutableStateOf("") }
    //variable used to reference the state of organizations pulled from the database through the signUpViewModel
    val organizationsState = signUpViewModel.organizations.collectAsState()
    //variable used to reference the values stored in the organizationState
    val organizations = organizationsState.value

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                // conditional statement used to determine the border color
                color = if (organizationName.isBlank() ||
                    isOrganizationNameTaken(organizationName, organizations )) Color.Red else Color.Transparent,
                width = 2.dp,
                shape = RectangleShape
            ),
        value = organizationName,
        onValueChange = { organizationName = it // will take in the input from the user
            errorMessage = ""  }, // Reset error message when user modifies the input
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        placeholder = { Text("Enter your organization", fontSize = 20.sp) },
        //supportingText = { Text(text = "*required") },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_add_business_24),
                contentDescription = "Business Icon"
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
    }
    // Display error message if organization name is already taken
    errorMessage.takeIf { it.isNotBlank() }?.let { message ->
        Text(
            text = message,
            color = Color.Red,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 30.dp, top = 4.dp)
        )
    }
}


// Function to check if the organization name is already taken
fun isOrganizationNameTaken(
    name: String,
    organizations: List<Organization>?,
): Boolean {
    var errorMessage : String
    organizations?.forEach { organization ->
        if (organization.organizationName == name) {
            // Set error message if organization name already exists in database
            errorMessage = ORGANIZATION_NAME_ALREADY_TAKEN
            return true
        }
    }
    // Clear error message if organization name is valid
    errorMessage = ""
    return false
}
/**
 * Function: Owner Organization Input
 * @author: Shianne Lesure
 * @author: Abdoulie NJie
 *
 * This function sets up the text-field for the user to be able to put in their full name to be able to
 * sign up. This is a requirement for the user to be able to navigate to the Upload screen.
 */
@Composable
fun ownerFullNameInput(){
    var fullName by remember { mutableStateOf("") } // variable that holds a default state of text-field
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                // conditional statement used to determine the border color
                color = if (fullName.isBlank())Color.Red else Color.Transparent,
                width = 2.dp,
                shape = RectangleShape
            ),
        value = fullName,
        onValueChange = { fullName = it }, // will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        placeholder = { Text("Enter your full name", fontSize = 20.sp) },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_drive_file_rename_outline_24),
                contentDescription = "Pencil Icon"
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
 *
 * This function sets up the text-field for the user to be able to put in their email to be able to
 * sign up. This is a requirement for the user to be able to navigate to the Upload screen.
 */
@Composable
fun emailInputOwner(signUpViewModel: SignUpViewModel) {
    var email by remember { mutableStateOf("") }// variable that holds a default state of text-field
    var errorMessage by remember { mutableStateOf("") }
    val usersState = signUpViewModel.users.collectAsState()
    val users = usersState.value

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                // conditional statement used to determine the border color
                color = if (email.isBlank() ||
                    isEmailTaken(email, users )) Color.Red else Color.Transparent,
                width = 2.dp,
                shape = RectangleShape
            ),
        value = email,
        onValueChange = { email = it // will take in the input from the user
                        errorMessage = ""}, // Reset error message when user modifies the input
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        placeholder = { Text("Enter email", fontSize = 20.sp) },
        /** The support text will not work if you have a modifier.*/
        //supportingText = { Text(text = "*required") },
        leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon") },
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
    }
    // Display error message if organization name is already taken
    errorMessage.takeIf { it.isNotBlank() }?.let { message ->
        Text(
            text = message,
            color = Color.Red,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 30.dp, top = 4.dp)
        )
    }
}

// Function to check if the email the user input's is already taken
fun isEmailTaken(
    email: String,
    users: List<User>?,
): Boolean {
    var errorMessage : String
    users?.forEach { users ->
        if (users.email == email) {
            // Set error message if organization name already exists in database
            errorMessage = EMAIL_ALREADY_TAKEN
            return true
        }
    }
    // Clear error message if organization name is valid
    errorMessage = ""
    return false
}

/**
 * Function: Password Input Owner
 * @author: Shianne Lesure
 *
 * This function set up the text-field for the user to be able to put in their password to be able to
 * sign up. This is a requirement for the user to be able to navigate to the Upload screen.
 */
@Composable
fun passwordInputOwner() {
    var password by remember { mutableStateOf("") }// variable that holds a default state of text-field
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                // conditional statement used to determine the border color
                color = if (password.isBlank())Color.Red else Color.Transparent,
                width = 2.dp,
                shape = RectangleShape
            ),
        value = password,
        onValueChange = { password = it }, // will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        placeholder = { Text("Enter password", fontSize = 20.sp) },
        visualTransformation = PasswordVisualTransformation(),// makes the password not visible to the user
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // This will show the black dots instead of letters
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock Icon") },
        trailingIcon = {
            //When clicked, it should switch the hidden icon to the eye icon
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.eye),
                    contentDescription = "Lock Icon"
                )
            }
        },
        /** This is for the hidden Icon that will turn the password hidden again.

        trailingIcon = {
        IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.eye), contentDescription = "Lock Icon")}
        },
         */
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
            text = "*required",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
    }
}

/**
 * Function: Password Strength Owner
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function displays the message of whether their password is strong or weak.
 * If their password is weak, a message pops up saying that that the passwords is weak and it needs
 * to be stronger.
 */
@Composable
fun passwordStrengthOwner(windowSize: WindowSize) {
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 20 else 30) }
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Password strength: ",
            fontSize = textSize.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        /*
        The password check would be coming from database. A if statement will be letting the user
        know if the password is weak or strong.

        if(password doesn't meet requirement ){
        Text(
            textAlign = TextAlign.Center,
            text = "Weak",
            fontSize = 30.sp,
            color = Color.Black
        )
        Text(
            textAlign = TextAlign.Center,
            text = "Password need to be stronger",
            fontSize = 30.sp,
            color = Color.Black
        )
        } else{
        Text(
            textAlign = TextAlign.Center,
            text = "Strong",
            fontSize = 30.sp,
            color = Color.Black
        )
        }
         */
        Text(
            textAlign = TextAlign.Center,
            text = "Weak",
            fontSize = textSize.sp,
            color = Color.Black
        )
    }
    Text(
        textAlign = TextAlign.Center,
        text = "Password need to be stronger",
        fontSize = textSize.sp,
        color = Color.Black
    )

    Spacer(modifier = Modifier.height(20.dp))

    passwordStrengthOwnerDialog(windowSize)
}

/**
 * Function: Password Strength Owner Dialog
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display a dialog when the why button is clicked. The dialog will show the user
 * what is needed to make their password stronger.
 */
@Composable
fun passwordStrengthOwnerDialog(windowSize: WindowSize) {
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 20 else 30) }

    // a variable that determines if the state of the dialog to be use or not
    var showDialog by remember { mutableStateOf(false) }
    Column {
        TextButton(onClick = { showDialog = true }) {
            Text(
                textAlign = TextAlign.Center,
                text = "Why?",
                fontSize = textSize.sp,
                color = Color.Black,
            )
        }
    }
    // the dialog shows if why button is clicked
    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {

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
                    Text(
                        text = "Passwords needs to be more than 8 characters.\n\n" +
                                "Must consist of one of each:\n" +
                                "- uppercase letter\n" +
                                "- symbol\n" +
                                "- digit\n" +
                                "- lower case letter",
                        fontSize = textSize.sp,
                        color = Color.Black,
                    )

                    //Close button
                    // will exit the dialog
                    Button(
                        onClick = { showDialog = false },
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Cornflower_blue),
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .border(3.dp, color = Persian_indigo),
                    ) {
                        Text(
                            "Close",
                            fontSize = textSize.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

/**
 * Function: Sign Snack Bar
 * @author: Shianne Lesure
 *
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
    val message by signUpViewModel.message.collectAsState(initial = "")

    // a variable that determines if the snack-bar will be displayed or not
    var showSnackBar by remember { mutableStateOf(false) }
    ElevatedButton(
        onClick = {
            signUpViewModel.onSignUp(isOwner)
            showSnackBar = true
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
    // the snack-bar will show if the login button is clicked
    if (showSnackBar) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { /*TODO*/
                    /* Will close the snack-bar and navigate to the next screen */
                    /** ask group about adding a button/snack bar that users can click to
                    // resend verification email once user has attempted to sign up
                    */
                })
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
                    .padding(top = snackBarPaddingTop.dp, start = snackBarPadding.dp),
                fontSize = 25.sp,
                color = Color.Black,
            )
        }
    }
}
