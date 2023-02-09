package com.hsb.mvvm_rooomdb.container

import android.app.Application
import com.hsb.mvvm_rooomdb.di.dbModule
import com.hsb.mvvm_rooomdb.di.demoModule
import com.hsb.mvvm_rooomdb.di.interfaceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(demoModule, interfaceModule, dbModule)
        }
    }
}