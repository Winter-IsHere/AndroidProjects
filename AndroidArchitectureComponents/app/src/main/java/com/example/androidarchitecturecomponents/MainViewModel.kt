package com.example.androidarchitecturecomponents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val quoteLiveData = MutableLiveData<String>("What you give is what you get")

    fun updateQuote(){
        quoteLiveData.value = "You'll see it when you believe it."
    }
}