package com.example.lablearnandroid

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel

class SensorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SensorScreen()
                }
            }
        }
    }
}

@Composable
fun SensorScreen(
    viewModel: SensorViewModel = viewModel()
) {
    val context = LocalContext.current
    val sensorData by viewModel.sensorData.collectAsState()

    var hasPermission by remember { mutableStateOf(false) }
    var isTracking by remember { mutableStateOf(false) }
    
    // Step 2 from Flow 1: Launcher for Permission
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val fineGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        val coarseGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false
        
        hasPermission = fineGranted || coarseGranted
        if (hasPermission) {
            isTracking = true
            viewModel.startTracking()
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.stopTracking()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "GPS Tracking (MVVM Architecture)",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(32.dp))

        // UI สำหรับปุ่ม Start / Stop Location
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {
                    val fineStatus = ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                    val coarseStatus = ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                    
                    if (fineStatus == PackageManager.PERMISSION_GRANTED || coarseStatus == PackageManager.PERMISSION_GRANTED) {
                        hasPermission = true
                        isTracking = true
                        viewModel.startTracking()
                    } else {
                        permissionLauncher.launch(
                            arrayOf(
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                            )
                        )
                    }
                },
                enabled = !isTracking
            ) {
                Text("Start Location")
            }

            Button(
                onClick = {
                    isTracking = false
                    viewModel.stopTracking()
                },
                enabled = isTracking
            ) {
                Text("Stop Location")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        if (isTracking) {
            if (sensorData != null) {
                Text(
                    text = "Latitude: ${sensorData?.latitude}",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Longitude: ${sensorData?.longitude}",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Accuracy: ${sensorData?.accuracy} meters",
                    style = MaterialTheme.typography.titleMedium
                )
            } else {
                Text(
                    text = "กำลังค้นหาพิกัด...",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        } else {
            Text(
                text = "กดปุ่ม Start เพื่อเริ่มดึงพิกัด",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
