package com.example.lab_5

import android.os.Bundle
import android.service.autofill.OnClickAction
import android.widget.HorizontalScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.lab_5.ui.theme.Lab_5Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_5Theme {
                // A surface container using the 'background' color from the theme
                Surface(


                ) {

                    Greeting("Androidвф")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String) {
    var selectedOption by rememberSaveable { mutableStateOf(0) }
    var num by rememberSaveable {
        mutableStateOf(0)
    }
    var result by rememberSaveable { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Row(
                modifier = Modifier.fillMaxWidth(.75F),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "Формат", style = TextStyle(fontSize = 25.sp))
                Text(text = "Стоимость", style = TextStyle(fontSize = 25.sp))
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.3F)
                .padding(vertical = 30.dp)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box(Modifier.weight(0.2f)) {
                    RadioButton(
                        selected = selectedOption == 0,
                        onClick = { selectedOption = 0
                            result = num * getPrice(selectedOption)},
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Box(Modifier.weight(0.4f)) {
                    Text(
                        text = "9X12", style = TextStyle(fontSize = 25.sp), modifier = Modifier
                            .align(Alignment.Center)
                            .offset(y = (8).dp)
                    )
                }
                Box(Modifier.weight(0.4f)) {
                    Text(
                        text = "100 руб.", style = TextStyle(fontSize = 25.sp), modifier = Modifier
                            .align(Alignment.Center)
                            .offset(y = (8).dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box(Modifier.weight(0.2f)) {
                    RadioButton(
                        selected = selectedOption == 1,
                        onClick = { selectedOption = 1
                            result = num * getPrice(selectedOption)},
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Box(Modifier.weight(0.4f)) {
                    Text(
                        text = "10X15", style = TextStyle(fontSize = 25.sp), modifier = Modifier
                            .align(Alignment.Center)
                            .offset(y = (8).dp)
                    )
                }
                Box(Modifier.weight(0.4f)) {
                    Text(
                        text = "150 руб.", style = TextStyle(fontSize = 25.sp), modifier = Modifier
                            .align(Alignment.Center)
                            .offset(y = (8).dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box(Modifier.weight(0.2f)) {
                    RadioButton(
                        selected = selectedOption == 2,
                        onClick = { selectedOption = 2
                            result = num * getPrice(selectedOption) },
                        modifier = Modifier.align(Alignment.Center),

                    )
                }
                Box(Modifier.weight(0.4f)) {
                    Text(
                        text = "18X24", style = TextStyle(fontSize = 25.sp), modifier = Modifier
                            .align(Alignment.Center)
                            .offset(y = (8).dp)
                    )
                }
                Box(Modifier.weight(0.4f)) {
                    Text(
                        text = "300 руб.", style = TextStyle(fontSize = 25.sp), modifier = Modifier
                            .align(Alignment.Center)
                            .offset(y = (8).dp)
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(vertical = 200.dp)
                .fillMaxWidth()
                .fillMaxHeight(.17F)

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Количество:", style = TextStyle(fontSize = 25.sp), modifier = Modifier
                        .offset(y = (10).dp)
                )
                TextField(
                    value = if (num == 0) "" else num.toString(),
                    onValueChange = { input ->
                        if (input.isEmpty() || !input.isDigitsOnly()) {
                            num = 0
                        } else {
                            num = input.toInt()
                        }
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    modifier = Modifier.size(width = 180.dp, height = 60.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(vertical = 270.dp)
                .fillMaxWidth()
                .fillMaxHeight(.25F)

        ) {

            Button(
                onClick = {
                    result = num * getPrice(selectedOption)
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Рассчитать", style = TextStyle(fontSize = 25.sp))
            }
        }
        Column(
            modifier = Modifier
                .padding(vertical = 330.dp)
                .fillMaxWidth()
                .fillMaxHeight(.35F)

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Text(
                    text = "Оплатить рублей: $result",
                    style = TextStyle(fontSize = 25.sp)
                )

            }
        }
    }


}

    fun getPrice(selectedOption: Int): Int {
        return when (selectedOption) {
            0 -> 100
            1 -> 150
            2 -> 300
            else -> 0
        }
    }




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab_5Theme {
        Greeting("Androifghdh")
    }
}