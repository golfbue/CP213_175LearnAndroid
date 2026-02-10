package com.example.a175lablearnandorid

import androidx.compose.foundation.shape.RoundedCornerShape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a175lablearnandorid.ui.theme._175LabLearnAndoridTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _175LabLearnAndoridTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ListScreen()
                }
            }
        }
    }
}

@Composable
fun ListScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB71C1C))
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF5F5F5)
            )
        ) {
            LazyColumn(
                modifier = Modifier.padding(12.dp)
            ) {
                items(allHololive) { item ->
                    HololiveItem(item)
                }
            }
        }
    }
}

@Composable
fun HololiveItem(item: Hololive) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "#${item.number}",
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.width(48.dp)
            )

            // ชื่อ
            Text(
                text = item.name,
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}


data class Hololive(
    val name: String,
    val number: Int
)

val allHololive = listOf(
    Hololive("Tokino Sora", 1),
    Hololive("Roboco", 2),
    Hololive("Hoshimachi Suisei", 3),
    Hololive("Sakura Miko", 4),
    Hololive("AZKi", 5),
    Hololive("Shirakami Fubuki", 6),
    Hololive("Natsuiro Matsuri", 7),
    Hololive("Akai Haato", 8),
    Hololive("Aki Rosenthal", 9),
    Hololive("Yozora Mel", 10),
    Hololive("Minato Aqua", 11),
    Hololive("Murasaki Shion", 12),
    Hololive("Nakiri Ayame", 13),
    Hololive("Yuzuki Choco", 14),
    Hololive("Oozora Subaru", 15),
    Hololive("Ookami Mio", 16),
    Hololive("Nekomata Okayu", 17),
    Hololive("Inugami Korone", 18),
    Hololive("Usada Pekora", 19),
    Hololive("Uruha Rushia", 20),
    Hololive("Shirogane Noel", 21),
    Hololive("Houshou Marine", 22),
    Hololive("Shiranui Flare", 23),
    Hololive("Tokoyami Towa", 24),
    Hololive("Amane Kanata", 25),
    Hololive("Tsunomaki Watame", 26),
    Hololive("Himemori Luna", 27),
    Hololive("Kiryu Coco", 28),
    Hololive("Yukihana Lamy", 29),
    Hololive("Momosuzu Nene", 30),
    Hololive("Shishiro Botan", 31),
    Hololive("Omaru Polka", 32),
    Hololive("La+ Darknesss", 33),
    Hololive("Takane Lui", 34),
    Hololive("Hakui Koyori", 35),
    Hololive("Sakamata Chloe", 36),
    Hololive("Kazama Iroha", 37),
    Hololive("Gawr Gura", 38),
    Hololive("Mori Calliope", 39),
    Hololive("Takanashi Kiara", 40),
    Hololive("Ninomae Ina'nis", 41),
    Hololive("Amelia Watson", 42),
    Hololive("IRyS", 43),
    Hololive("Ceres Fauna", 44),
    Hololive("Ouro Kronii", 45),
    Hololive("Nanashi Mumei", 46),
    Hololive("Hakos Baelz", 47),
    Hololive("Shiori Novella", 48),
    Hololive("Koseki Bijou", 49),
    Hololive("Nerissa Ravencroft", 50),
    Hololive("Fuwawa Abyssgard", 51),
    Hololive("Mococo Abyssgard", 52)
)

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    _175LabLearnAndoridTheme {
        ListScreen()
    }
}

