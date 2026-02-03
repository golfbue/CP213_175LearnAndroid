package com.example.a175lablearnandorid

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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

                    // image
                    Image(
                        painter = painterResource(id = R.drawable.kagari),
                        contentDescription = "kagari",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                            .padding(20.dp)
                    )
                    // status
                }
            }
        }
    }
}
