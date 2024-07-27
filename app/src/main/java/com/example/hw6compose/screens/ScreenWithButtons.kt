package com.example.hw6compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hw6compose.R
import com.example.hw6compose.theme.GrayTransparent
import com.example.hw6compose.theme.GreenTransparent

@Composable
fun ScreenWithButtons(navController: NavController) {


    var clicked = remember { mutableStateOf(false) }

    var color = if (clicked.value) GreenTransparent else GrayTransparent

    var buttonText = if (clicked.value) "from gray to green" else "from green to gray"

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.field),
        contentDescription = "background",
        contentScale = ContentScale.FillBounds
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.size(250.dp, 150.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(color),

            onClick = {
                clicked.value = !clicked.value
            }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Click", fontSize = 50.sp)
                Text(text = "to change color", fontSize = 20.sp)
                Text(text = "$buttonText", fontSize = 20.sp)
            }

        }
        NavButton(navController)
    }


}

@Composable
fun NavButton(
    navController: NavController
) {
    Button(
        modifier = Modifier.size(250.dp, 100.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(GrayTransparent),
        onClick = { navController.navigate("main_screen") }
    )
    {
        Text(
            text = "Click to get list of matches",
            style = TextStyle(fontSize = 25.sp),
            textAlign = TextAlign.Center
        )
    }
}
