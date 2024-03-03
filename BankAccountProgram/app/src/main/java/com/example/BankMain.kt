package com.example

fun main(){
    var wintersAccount = BankAccount("Winter", 123.4)
    wintersAccount.deposit(20.0)
    wintersAccount.displayTransactionHistory()

}