package com.hsb.mvvm_rooomdb.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.hsb.mvvm_rooomdb.Model.userNode
import com.hsb.mvvm_rooomdb.NodeDao.DB
import com.hsb.mvvm_rooomdb.NodeRepo.UserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val appDatabase: UserRepo
    lateinit var data: LiveData<List<userNode>>

    init {
        val dao = DB.getDB(application.applicationContext).userDao()
        appDatabase = UserRepo(dao)
    }

    fun insert  (node: userNode) {
        viewModelScope.launch(Dispatchers.IO) {
            appDatabase.adduser(node)
        }
    }

    fun readall(): LiveData<List<userNode>> {
        Log.e("Read Data", "in vm is called")
        return appDatabase.readall()
    }

    fun delete_node(node: userNode) {
        viewModelScope.launch(Dispatchers.IO) {
            appDatabase.delete_one(node)
        }
    }

    fun update_node(node: userNode) {
        viewModelScope.launch(Dispatchers.IO) {
            appDatabase.update_node(node)
        }
    }

    fun delete_all() {
        viewModelScope.launch(Dispatchers.IO) {
            appDatabase.delete_all()
        }
    }
}