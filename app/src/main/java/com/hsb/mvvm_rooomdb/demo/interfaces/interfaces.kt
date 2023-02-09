package com.hsb.mvvm_rooomdb.demo.interfaces

import android.util.Log

interface DemoOne {
    fun getDemoOne()
}

class DemoImp : DemoOne {
    override fun getDemoOne() {
        Log.e("Interface", "Implement")
    }
}

class Main(private val demoOne: DemoOne) {
    fun getDemo() {
        demoOne.getDemoOne()
    }
}