package com.hsb.mvvm_rooomdb.demo

import android.util.Log

class Car constructor(private val engine: Engine, private val wheel: Wheel) {
    fun getCar() {
        engine.startengine()
        wheel.movewheel()
        Log.e("Car", "Car is running")
    }
}

class Engine {
    fun startengine() {
        Log.e("Car", "Engine started..")
    }
}

class Wheel {
    fun movewheel() {
        Log.e("Car", "Wheel moving..")
    }
}