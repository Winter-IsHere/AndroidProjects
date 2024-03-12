package com.example.kotlinbasics

import kotlinx.coroutines.processNextEventInCurrentThread

data class Potion(
    val name: String,
    val effect: String,
    val potency : Int
)

fun main(){
    val healingPotion = Potion("Healing Potion", "Restores health", 50)
    val invisibilityPotion = Potion("Invisibility Potion", "Grants invisibility", 40)
    val strengthPotion = Potion("Strength Potion", "Boosts strength", 60)

    val potionList = listOf(healingPotion,invisibilityPotion,strengthPotion)
    println(potionList)
}