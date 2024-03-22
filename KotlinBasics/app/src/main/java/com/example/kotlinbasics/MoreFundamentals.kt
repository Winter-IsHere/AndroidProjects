package com.example.kotlinbasics


class OuterClass{
    private val name: String = "Hello"
//    val num : Int = 2
    inner class InnerClass{
        var description : String = "This is code which is inside nested class"
        private val id : Int = 101
        fun foo(){
            println("Name is $name") //Cannot access the outer class member
            println("ID is $id")
        }
    }
}
fun main(){
    //nested class must be initialized
    println(OuterClass().InnerClass().description)

    val obj1 = OuterClass()
    obj1.InnerClass().foo()
}
