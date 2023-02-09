package com.hsb.mvvm_rooomdb.NodeRepo

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.hsb.mvvm_rooomdb.NodeDao.userDao
import com.hsb.mvvm_rooomdb.Model.userNode

class UserRepo(val dao: userDao) {

    fun adduser(node: userNode) {
        dao.insert(node)
    }

    fun readall(): LiveData<List<userNode>> {
        Log.e("Read Data", "in repo is called")
        return dao.readall()
    }

    suspend fun delete_one(node: userNode) {
        dao.delete_one(node)
    }

    suspend fun update_node(node: userNode) {
        dao.update_node(node)
    }

    suspend fun delete_all() {
        dao.delete_all()
    }
}