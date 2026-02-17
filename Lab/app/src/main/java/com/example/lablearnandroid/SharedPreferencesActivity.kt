package com.example.lablearnandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lablearnandroid.ui.theme.LabLearnAndroidTheme
import com.example.lablearnandroid.utils.SharedPreferencesUtil

class SharedPreferencesUtilActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ✅ 1. init ก่อนใช้งาน
        SharedPreferencesUtil.init(this)

        // ✅ 2. ทดลองบันทึกค่า
        SharedPreferencesUtil.saveString("user_name", "Sirapop")
        SharedPreferencesUtil.saveBoolean("is_dark_mode", true)

        // ✅ 3. ทดลองอ่านค่า
        val name = SharedPreferencesUtil.getString("user_name")
        val darkMode = SharedPreferencesUtil.getBoolean("is_dark_mode")

        Log.d("SharedPrefTest", "สวัสดีคุณ: $name, DarkMode: $darkMode")

        enableEdgeToEdge()
        setContent {
            LabLearnAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = name ?: "Sirapop",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    LabLearnAndroidTheme {
        Greeting2("Android")
    }
}
