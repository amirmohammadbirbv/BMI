package com.example.run

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.run.ui.theme.RunTheme
import kotlin.math.roundToInt


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RunTheme {
                Scaffold(
                    topBar = {
                        topBar()
                    },
                    bottomBar = {
                        BottomBar()
                    }, content = {
                        it
                        content()
                    }
                )
            }
        }
    }
}

var SliderHeight = mutableStateOf(150)
var Weight = mutableStateOf(50)

@Composable
fun content() {
    Column(
        Modifier
            .background(if (MaterialTheme.colors.isLight) Color.White else Color(0xFF1B1A1B))
            .fillMaxSize()
            .padding(bottom = 60.dp)
    ) {
        Row(
            modifier = Modifier
                .weight(3.5f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Sex()
        }
        Row(
            modifier = Modifier
                .weight(3.5f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            GetHeight()
        }
        Row(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Age()
        }
    }
}

@Composable
fun Age() {
    var weight by remember {
        Weight
    }
    Card(
        elevation = 30.dp,
        modifier = Modifier
            .fillMaxWidth(0.40f)
            .fillMaxHeight(0.9f),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Text(
                text = "WEIGHT",
                fontSize = 18.sp,
                color = MaterialTheme.colors.onBackground
            )
            Text(
                text = weight.toString(),
                fontSize = 35.sp,
                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.Bold
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Card(
                    border = BorderStroke(2.dp, MaterialTheme.colors.onBackground),
                    shape = CircleShape,
                    backgroundColor = Color.LightGray,
                    modifier = Modifier
                        .size(50.dp)

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable(onClick = { weight++ }),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "+",
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }
                Card(
                    border = BorderStroke(2.dp, MaterialTheme.colors.onBackground),
                    shape = CircleShape,
                    backgroundColor = Color.LightGray,
                    modifier = Modifier
                        .size(50.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable(onClick = { weight-- }),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "-",
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }
            }
        }
    }
    var age by remember {
        mutableStateOf(10)
    }
    Card(
        elevation = 30.dp,
        modifier = Modifier
            .fillMaxWidth(0.65f)
            .fillMaxHeight(0.9f),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Text(
                text = "AGE",
                fontSize = 18.sp,
                color = MaterialTheme.colors.onBackground
            )
            Text(
                text = age.toString(),
                fontSize = 35.sp,
                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.Bold
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Card(
                    border = BorderStroke(2.dp, MaterialTheme.colors.onBackground),
                    shape = CircleShape,
                    backgroundColor = Color.LightGray,
                    modifier = Modifier.size(50.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable(onClick = { age++ }),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "+",
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }
                Card(
                    border = BorderStroke(2.dp, MaterialTheme.colors.onBackground),
                    shape = CircleShape,
                    backgroundColor = Color.LightGray,
                    modifier = Modifier.size(50.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable(onClick = { age-- }),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "-",
                            fontWeight = FontWeight.Bold,
                            fontSize = 40.sp,
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Sex() {
    var getSex by remember {
        mutableStateOf(true)
    }
    Card(
        elevation = 30.dp,
        modifier = Modifier
            .fillMaxWidth(0.40f)
            .fillMaxHeight(0.9f),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .selectable(onClick = { getSex = true }, selected = getSex)
                .background(if (getSex) MaterialTheme.colors.secondaryVariant else MaterialTheme.colors.background),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "",
                Modifier.size(70.dp),
                tint = MaterialTheme.colors.onBackground
            )
            Text(text = "Male", fontSize = 20.sp, color = Color.DarkGray)
        }
    }
    Card(
        elevation = 30.dp,
        modifier = Modifier
            .fillMaxWidth(0.65f)
            .fillMaxHeight(0.9f),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .selectable(onClick = { getSex = false }, selected = !getSex)
                .background(if (!getSex) MaterialTheme.colors.secondaryVariant else MaterialTheme.colors.background),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Filled.AccountBox,
                contentDescription = "",
                Modifier.size(70.dp),
                tint = MaterialTheme.colors.onBackground
            )
            Text(text = "Female", fontSize = 20.sp, color = Color.DarkGray)
        }
    }
}

@Composable
fun GetHeight() {
    var position by remember {
        SliderHeight
    }
    Card(
        modifier = Modifier
            .fillMaxHeight(0.9f)
            .fillMaxWidth(0.85f), elevation = 30.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Text(
                text = "HEIGHT",
                fontSize = 18.sp,
                color = MaterialTheme.colors.onBackground
            )
            Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center, Alignment.Bottom) {
                Text(
                    text = position.toString(),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
                Text(
                    text = "cm",
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onBackground
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Slider(
                value = position / 300f,
                onValueChange = { position = ((it * 300).roundToInt()) })
        }
    }
}

@Composable
fun BottomBar() {
    var He = SliderHeight.value
    var We = Weight.value
    val BMI = We/(He/100f*He/100f)
    var alertDialog by remember {
        mutableStateOf(false)
    }
    Row(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Red)
            .clickable(onClick = {

                alertDialog = true
            }),
        Arrangement.Center,
        Alignment.CenterVertically
    ) {
        Text(text = "CALCULATOR", color = Color.White, fontSize = 22.sp)
    }
    if (alertDialog) {
        AlertDialog(
            onDismissRequest = {
                alertDialog = false
            },
            title = {
                Text(text = "Result Of Your BMI Test")
            },
            text = {Text(text = "You Have ${BMI.roundToInt()} Of Crosstool")},
            confirmButton = {},
            dismissButton = {
                Button(onClick = {
                    alertDialog = false
                }) {
                    Text(text = "OK")
                }
            }
        )
    }
}


@Composable
fun topBar() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "BMI CALCULATOR",
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 22.sp
                )
            }
        },
        backgroundColor = if (MaterialTheme.colors.isLight) Color.White else Color(0xFF1B1A1B)
    )
}
