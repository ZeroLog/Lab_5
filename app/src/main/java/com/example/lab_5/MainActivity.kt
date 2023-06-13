package com.example.lab_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab_5.ui.theme.Lab_5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Androidвф")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val selectedOption = remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row() {
            Text(text = "Формат")
            Text(text = "Стоимость")
        }
        Column(
            modifier = Modifier,
        ) {
            Row() {
                RadioButton(
                    selected = selectedOption.value == 0,
                    onClick = { selectedOption.value = 0 }
                )
                Text(
                    text = "Hello $name!",
                    modifier = Modifier
                        .offset(y = 12.dp)
                )
            }
            Row() {
                RadioButton(
                    selected = selectedOption.value == 1,
                    onClick = { selectedOption.value = 1 }
                )
                Text(
                    text = "Hello $name!",
                    modifier = Modifier
                        .offset(y = 12.dp)
                )
            }
            Row() {
                RadioButton(
                    selected = selectedOption.value == 2,
                    onClick = { selectedOption.value = 2 }
                )
                Text(
                    text = "Hello $name!",
                    modifier = Modifier
                        .offset(y = 12.dp)
                )
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab_5Theme {
        Greeting("Androifghdh")
    }
}