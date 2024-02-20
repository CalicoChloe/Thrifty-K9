package com.example.pricingpal.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteOwner() {
    //TODO
}/*{
    val cardSpacer by remember(key1 = ""*//*TODO*//*) { mutableStateOf(if (windowSize.width == WindowType.Compact) 25 else 40) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Anti_flash_white
    ) {
        Image(
            painter = painterResource(id = R.drawable.paw_background),
            contentDescription = "Pictures of Paws",
            contentScale = ContentScale.Crop,
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
                topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Cornflower_blue
                        ),
                        title = {
                            Text(text = "Settings")
                        },
                        navigationIcon = {
                            IconButton(
                                onClick = { *//*TODO*//* },
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Back arrow Button",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .size(50.dp)
                                )
                            }

                        },
                    )
                },

                content = { padding -> DeleteOwner(padding, windowSize) },
                containerColor = Persian_indigo
            )
        }
    }*/


@Composable
fun PerformDeleteAction() {
//Not going to need, will call from impl
}