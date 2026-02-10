package com.example.a175lablearnandorid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a175lablearnandorid.ui.theme._175LabLearnAndoridTheme

class MainActivity2 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            _175LabLearnAndoridTheme {

                val context = LocalContext.current

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Gray)
                        .padding(32.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(32.dp)
                            .background(Color.White)
                    ) {
                        Text(
                            text = "hp",
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .fillMaxWidth(0.75f)
                                .background(Color.Red)
                                .padding(8.dp)
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ayame),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                            .padding(20.dp)
                            .clickable {
                                val intent = Intent(
                                    context,
                                    com.example.a175lablearnandorid.ListActivity::class.java
                                )
                                context.startActivity(intent)
                            }
                    )

                    var sp by remember { mutableStateOf(8) }
                    var agi by remember { mutableStateOf(8) }
                    var cute by remember { mutableStateOf(8) }

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

                            // strength
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Button(onClick = { sp++ }) {
                                    Image(
                                        painter = painterResource(id = R.drawable.up),
                                        contentDescription = null,
                                        modifier = Modifier.size(40.dp)
                                    )
                                }
                                Text("Stange", fontSize = 28.sp, color = Color.Blue)
                                Text(sp.toString(), fontSize = 28.sp, color = Color.Red)
                                Image(
                                    painter = painterResource(id = R.drawable.down),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clickable { sp-- }
                                )
                            }

                            // agility
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Button(onClick = { agi++ }) {
                                    Image(
                                        painter = painterResource(id = R.drawable.up),
                                        contentDescription = null,
                                        modifier = Modifier.size(40.dp)
                                    )
                                }
                                Text("Argility", fontSize = 28.sp, color = Color.Blue)
                                Text(agi.toString(), fontSize = 28.sp, color = Color.Red)
                                Image(
                                    painter = painterResource(id = R.drawable.down),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clickable { agi-- }
                                )
                            }

                            // cute
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Button(onClick = { cute++ }) {
                                    Image(
                                        painter = painterResource(id = R.drawable.up),
                                        contentDescription = null,
                                        modifier = Modifier.size(40.dp)
                                    )
                                }
                                Text("Cute", fontSize = 28.sp, color = Color.Blue)
                                Text(cute.toString(), fontSize = 28.sp, color = Color.Red)
                                Image(
                                    painter = painterResource(id = R.drawable.down),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clickable { cute-- }
                                )
                            }
                        }
                    }
                }
            }
        }
    }


    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "MainActivity2 onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "MainActivity2 onPause")
    }
}
