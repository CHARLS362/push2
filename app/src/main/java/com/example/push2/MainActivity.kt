package com.example.push2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val extras = intent.extras?.let { bundle ->
            bundle.keySet().associateWith { key -> bundle.getString(key).orEmpty() }
        } ?: emptyMap()

        setContent {
            MaterialTheme {
                InfoScreen(extras)
            }
        }
    }
}

@Composable
fun InfoScreen(extras: Map<String, String>) {
    Column(modifier = Modifier.padding(16.dp)) {
        if (extras.isNotEmpty()) {
            extras.forEach { (key, value) ->
                Text(text = "$key: $value")
            }
        } else {
            Text(text = "No hay extras en el Intent")
        }
    }
}
