package com.hsb.mvvm_rooomdb.di

import android.app.Application
import com.hsb.mvvm_rooomdb.NodeRepo.UserRepo
import com.hsb.mvvm_rooomdb.ViewModel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    single { MainViewModel(androidContext() as Application) }
}