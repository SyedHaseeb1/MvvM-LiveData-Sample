package com.hsb.mvvm_rooomdb.container

import com.hsb.mvvm_rooomdb.NodeRepo.UserRepo
import com.hsb.mvvm_rooomdb.ViewModel.MainViewModel
import com.hsb.mvvm_rooomdb.demo.Car
import com.hsb.mvvm_rooomdb.demo.interfaces.Main
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Component : KoinComponent {
    val car: Car by inject()
    val main: Main by inject()
    val dbComponent: UserRepo by inject()
    val vmComponent: MainViewModel by inject()

}