package com.example.kotlinbasics

class Dog(val name: String, val breed : String, var age: Int = 0 ){
    init {
        bark()
    }
    private fun bark(){
        println("Bhau Bhau")
    }
}

fun main(){
    var tDog = Dog("Tipu", "German Shepherd", 4)
    println("${tDog.name} is a ${tDog.breed} and is ${tDog.age} years old")
}