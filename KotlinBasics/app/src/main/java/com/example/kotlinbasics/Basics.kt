package com.example.kotlinbasics

import kotlinx.coroutines.processNextEventInCurrentThread

fun main() {
//    println("Enter the value of a\n")
//    var a = readln().toInt()
//    println("You entered $a")
//    if (a > 3){
//        println("Welcome to Winter's Space")
//    }
//    else if(a < 3)
//       println("Get out!!")
//    else{
//        println("How aer you")
//    }
//    val randomNumber = (1..4).random()
//    println(randomNumber)
//    for (i in 1..4){
//        println(i)
//    }
//    var count = 0
//    //While Loop
//    while (count < 3){
//        println(count)
//        count++
//    }
    //Calling the Function
//    println("Enter Your Name")
//    val name = readln()
//    println("Enter how many spoons of sugar you want in your coffee")
//    val sugarCount = readln().toInt()
//    makeCoffee(sugarCount,name)
//    println(addition(3,5))

    //Lists in Kotlin
    var shoppingList = listOf("Processor", "RAM", "SSD", "Graphics Card") // list of method creates an immutable list)
//    //Mutable List
//    var anotherShoppingList = mutableListOf<Int>(1,4,5)
//    print(anotherShoppingList)
     //For loops
    for (i in 0 until shoppingList.size){
        print(shoppingList[i])
    }

}

fun addition(num1:Int,num2:Int): Int {
    return num1+num2
}
//Defining the function
fun makeCoffee(sugarCount:Int, name:String){
    if (sugarCount <= 1){
        println("Hey $name , Here is Your Coffee with $sugarCount spoon of sugar! Enjoy")
    }
    else{
        println("Hey $name, Here is Your Coffee with $sugarCount spoons of sugar! Enjoy")
    }

}