package com.hsb.mvvm_rooomdb.di

import com.hsb.mvvm_rooomdb.demo.interfaces.DemoImp
import com.hsb.mvvm_rooomdb.demo.interfaces.DemoOne
import com.hsb.mvvm_rooomdb.demo.interfaces.Main
import org.koin.dsl.bind
import org.koin.dsl.module

val interfaceModule = module {
//    factory<DemoOne> { DemoImp() }

    factory { DemoImp() } bind DemoOne::class
    factory {
        Main(get())
    }
}