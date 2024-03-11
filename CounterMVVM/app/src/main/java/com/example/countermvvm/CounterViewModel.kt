package com.example.countermvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _count = mutableIntStateOf(0)

    val count: MutableState<Int> = _count

    fun increment() {
        count.value++
    }

    fun decrement() {
        count.value--
    }
}