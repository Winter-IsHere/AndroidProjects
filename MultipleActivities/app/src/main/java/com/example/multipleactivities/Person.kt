package com.example.multipleactivities

import java.io.Serializable

data class Person(
    var name : String,
    var age : Int,
    var country : String
) : Serializable