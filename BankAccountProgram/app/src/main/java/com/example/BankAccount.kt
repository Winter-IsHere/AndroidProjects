package com.example

class BankAccount (var accountHolder: String, var balance : Double = 0.0){
    private var transactionHistory = mutableListOf<String>()
    fun deposit(amount: Double){
        balance += amount
        transactionHistory.add("${accountHolder} deposited $${amount}")
    }
    fun withdraw(amount: Double){
        if (amount <= balance){
            balance -= amount
            transactionHistory.add("${accountHolder} withdrew $${amount}")
        }
        else
        {
            println("You don't have enough balance to withdraw $${amount}")
        }
    }
    fun displayTransactionHistory(){
        println("Below is the Transaction History Of Account Holder: $accountHolder")
        for (transaction in transactionHistory){
            println(transaction)
        }
        println("The Remaining Balance is: $$balance")
    }
}
