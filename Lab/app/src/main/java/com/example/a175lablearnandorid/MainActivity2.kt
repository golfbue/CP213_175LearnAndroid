package com.example.a175lablearnandorid


import android.app.ListActivity
import androidx.compose.ui.platform.LocalContext
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a175lablearnandorid.ui.theme._175LabLearnAndoridTheme


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _175LabLearnAndoridTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Gray)
                        .padding(32.dp)
                ) {
                    // hp
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(32.dp)
                            .background(color = Color.White)
                    ) {
                        Text(
                            text = "hp",
                            modifier = Modifier
                                .align(alignment = Alignment.CenterStart)
                                .fillMaxWidth(fraction = 0.75f)
                                .background(color = Color.Red)
                                .padding(8.dp)

                        )
                    }
                    val context = LocalContext.current
                    // image
                    Image(
                        painter = painterResource(id = R.drawable.ayame),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                            .padding(20.dp)
                            .clickable {
                                val intent = Intent(context, MainActivity::class.java)
                                context.startActivity(intent)
                            }
                    )

                    var sp by remember { mutableStateOf(8) }
                    var agi by remember { mutableStateOf(8) }
                    var cute by remember { mutableStateOf(8) }

                    // status
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Button(
                                    onClick = {
                                        sp = sp + 1
                                    }
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.up),
                                        contentDescription = "Profile",
                                        modifier = Modifier
                                            .size(40.dp)
                                    )
                                }
                                Text(text = "Stange", fontSize = 28.sp, color = Color.Blue)
                                Text(text = sp.toString(), fontSize = 28.sp, color = Color.Red)
                                Image(
                                    painter = painterResource(id = R.drawable.down),
                                    contentDescription = "Profile",
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clickable { sp = sp - 1 }
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Button(
                                    onClick = {
                                        agi = agi + 1
                                    }
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.up),
                                        contentDescription = "Profile",
                                        modifier = Modifier
                                            .size(40.dp)
                                    )
                                }
                                Text(text = "Argility", fontSize = 28.sp, color = Color.Blue)
                                Text(text = agi.toString(), fontSize = 28.sp, color = Color.Red)
                                Image(
                                    painter = painterResource(id = R.drawable.down),
                                    contentDescription = "Profile",
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clickable { agi = agi - 1 }
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Button(
                                    onClick = {
                                        cute = cute + 1
                                    }
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.up),
                                        contentDescription = "Profile",
                                        modifier = Modifier
                                            .size(40.dp)
                                    )
                                }
                                Text(text = "Cute", fontSize = 28.sp, color = Color.Blue)
                                Text(text = cute.toString(), fontSize = 28.sp, color = Color.Red)
                                Image(
                                    painter = painterResource(id = R.drawable.down),
                                    contentDescription = "Profile",
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clickable { cute = cute - 1 }
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}
