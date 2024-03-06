package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        CaptainGame()
                }
            }
        }
    }
    @Composable
    fun CaptainGame(){
        var treasureFound by remember { mutableIntStateOf(0) }
        val direction = remember { mutableStateOf("North") }
        val stormOrTreasure = remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Treasures Found: $treasureFound")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Current Direction: ${direction.value}")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { 
                direction.value = "North"
                if (Random.nextBoolean()){
                    treasureFound += 1
                    stormOrTreasure.value = "Found a Treasure!"
                }else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }) {
                Text(text = "Sail North")
            }
            Button(onClick = {
                direction.value = "South"
                if (Random.nextBoolean()){
                    treasureFound += 1
                    stormOrTreasure.value = "Found a Treasure!"
                }else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }) {
                Text(text = "Sail South")
            }
            Button(onClick = {
                direction.value = "East"
                if (Random.nextBoolean()){
                    treasureFound += 1
                    stormOrTreasure.value = "Found a Treasure!"
                }else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }) {
                Text(text = "Sail East")
            }
            Button(onClick = {
                direction.value = "West"
                if (Random.nextBoolean()){
                    treasureFound += 1
                    stormOrTreasure.value = "Found a Treasure!"
                }else{
                    stormOrTreasure.value = "Storm Ahead!"
                }
            }) {
                Text(text = "Sail West")
            }
            Text(text = stormOrTreasure.value)
        }
    }
}

