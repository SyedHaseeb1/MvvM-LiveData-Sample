package com.hsb.mvvm_rooomdb.di

import com.hsb.mvvm_rooomdb.demo.Car
import com.hsb.mvvm_rooomdb.demo.Engine
import com.hsb.mvvm_rooomdb.demo.Wheel
import com.hsb.mvvm_rooomdb.demo.interfaces.Main
import org.koin.dsl.module

val demoModule = module {
    factory { Engine() }
    factory { Wheel() }
    factory { Car(get(), get()) }
    factory { Main(get()) }
}