package com.example.kotlinbasics

import kotlin.random.Random

//Rock Paper Scissors Project
fun main(){
    println("Enter Your Choice : Rock, Paper or Scissor")
    var userChoice = readln()
    while ((userChoice != "Rock") && (userChoice != "Paper") && (userChoice != "Scissor")){
        println("Enter Your Choice : Rock, Paper or Scissor")
        userChoice = readln()
    }
    val list = listOf("Rock","Paper","Scissor")
    val randomIndex = Random.nextInt(list.size)
    var computerChoice = list[randomIndex]
    println(computerChoice)

    if ((userChoice == "Rock" && computerChoice == "Rock") ||(userChoice == "Paper" && computerChoice == "Paper") || (userChoice == "Scissor" && computerChoice == "Scissor"))
    {
        println("It's a Tie!!!")
    }
    else if((userChoice == "Rock" && computerChoice == "Scissor") ||(userChoice == "Paper" && computerChoice == "Rock") || (userChoice == "Scissor" && computerChoice == "Paper"))
    {
        println("You Won!!!")
    }
    else{
        println("Computer Won!!!")
    }

}