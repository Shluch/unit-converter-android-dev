package com.example.myfirstapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                   UnitConveter()
                }
            }
        }
    }
}

@Composable
fun UnitConveter(){

    var inputvalue by remember{ mutableStateOf("") }
    var outputvalue by remember{ mutableStateOf("") }
    val ConverstionFactor = remember{ mutableStateOf(0.01) }
    val oConverstionFactor = remember{ mutableStateOf(0.01) }
    var outputunit by remember{ mutableStateOf("Select") }
    var inputunit by remember{ mutableStateOf("Select") }
    var iexpandaded by remember{ mutableStateOf(false) }
    var oexpandaded by remember{ mutableStateOf(false) }

    fun unitConverter() {
        val inputVar = inputvalue.toDoubleOrNull()?: 0.0
        val result = (inputVar * ConverstionFactor.value * 100/oConverstionFactor.value)/ 100
        outputvalue = result.toString()

    }
    Column( modifier = Modifier.fillMaxSize(),
             verticalArrangement = Arrangement.Center
             , horizontalAlignment =  Alignment.CenterHorizontally
             ) {
        Text(text = "Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputvalue,
            onValueChange = {
                inputvalue = it
            },
            label = { Text(text = "Enter the value ") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Result: $outputvalue")
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            //Input button
            Box{
                // Input box
                Button(onClick = { iexpandaded = true }) {
                    Text(text = inputunit)
                    Icon(Icons.Default.ArrowDropDown,"ArrowDown")

                }
                DropdownMenu(expanded = iexpandaded, onDismissRequest = { iexpandaded=false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter") }, onClick = {
                        iexpandaded =false
                        inputunit = "Centimeter"
                        ConverstionFactor.value = 0.01
                        unitConverter()
                    })
                    DropdownMenuItem(text = { Text(text = "Meter") }, onClick = {
                        iexpandaded =false
                        inputunit = "Meter"
                        ConverstionFactor.value = 1.0
                        unitConverter()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        iexpandaded =false
                        inputunit = "Feet"
                        ConverstionFactor.value = 0.3048
                        unitConverter()
                    })
                    DropdownMenuItem(text = { Text(text = "Milimeter") }, onClick = {
                        iexpandaded =false
                        inputunit = "Milimeter"
                        ConverstionFactor.value = 0.01
                        unitConverter() })

                }

            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                // Output Box
                Button(onClick = { oexpandaded = true }) {
                    Text(text = outputunit)
                    Icon(Icons.Default.ArrowDropDown,"ArrowDown")

                }
                DropdownMenu(expanded = oexpandaded, onDismissRequest = { oexpandaded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeter") }, onClick = {
                        oexpandaded =false
                        outputunit = "Centimeter"
                        oConverstionFactor.value = 0.01
                        unitConverter()

                })
                    DropdownMenuItem(text = { Text(text = "Milimeter") }, onClick = {
                        oexpandaded =false
                        outputunit = "Milimeter"
                        oConverstionFactor.value = 0.001
                        unitConverter()

                    })
                    DropdownMenuItem(text = { Text(text = "Meter") }, onClick = {
                        oexpandaded =false
                        outputunit = "Meter"
                        oConverstionFactor.value = 1.0
                        unitConverter()

                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        oexpandaded =false
                        outputunit = "Feet"
                        oConverstionFactor.value = 0.3048
                        unitConverter()

                    })

                }


            }


            }
        }
    }




@Preview(showBackground = true)
@Composable
fun preview(){
    UnitConveter()
}