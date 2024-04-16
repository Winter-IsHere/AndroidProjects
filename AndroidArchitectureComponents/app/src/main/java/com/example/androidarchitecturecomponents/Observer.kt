package com.example.androidarchitecturecomponents

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Observer: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun myOnCreate(){
        Log.d("MAIN", "Observer - on create")
    }
}