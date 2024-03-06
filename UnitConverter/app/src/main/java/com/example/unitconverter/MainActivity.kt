package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxHeight(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter(){
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    var conversionFactor = remember { mutableDoubleStateOf(1.0) }
    var oConversionFactor = remember { mutableDoubleStateOf(1.0) }

    fun convertUnit(){
        var inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        var result = (inputValueDouble * conversionFactor.value * 100.0 / oConversionFactor.value ).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //Here all the UI elements will be stacked below each other
        Text("Unit Converter", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value =inputValue ,
            onValueChange = {
                inputValue = it
                convertUnit() },
            label = { Text(text = "Enter Value")}
            )
        Spacer(modifier = Modifier.height(16.dp))
        Row{
            //Input Box
            Box{
                //Input Button
                Button(onClick = { iExpanded = true }) {
                    Text(inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "This is Arrow Drop Down")
                }
                DropdownMenu(
                    expanded = iExpanded,
                    onDismissRequest = {
                        iExpanded = false

                }) {
                        DropdownMenuItem(
                            text = { Text("Centimeters") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Centimeters"
                                conversionFactor.doubleValue = 0.01
                                convertUnit()
                            })
                        DropdownMenuItem(
                            text = { Text("Meters") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Meters"
                                conversionFactor.doubleValue = 1.0
                                convertUnit()
                            })
                        DropdownMenuItem(
                            text = { Text("Feet") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Feet"
                                conversionFactor.doubleValue = 0.3048
                                convertUnit()
                            })
                        DropdownMenuItem(
                            text = { Text("Inch") },
                            onClick = {
                                iExpanded = false
                                inputUnit = "Inch"
                                conversionFactor.doubleValue = 0.0254
                                convertUnit()
                            })

                    }
            }
            Spacer(modifier = Modifier.width(16.dp))
            //Output Box
            Box{
                Button(onClick = { oExpanded = true }) {
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "This is Arrow Drop Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = {
                    oExpanded = false
                }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Centimeters"
                            oConversionFactor.doubleValue = 0.01
                            convertUnit()
                        })
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Meters"
                            oConversionFactor.doubleValue = 1.0
                            convertUnit()
                        })
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Feet"
                            oConversionFactor.doubleValue = 0.3048
                            convertUnit()
                        })
                    DropdownMenuItem(
                        text = { Text("Inch") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Inch"
                            oConversionFactor.doubleValue = 0.0254
                            convertUnit()
                        })

                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result: $outputValue $outputUnit", style = MaterialTheme.typography.headlineMedium)
    }

}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview()
{
    UnitConverter()
}

