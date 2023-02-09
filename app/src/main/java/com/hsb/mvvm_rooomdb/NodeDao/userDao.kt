package com.hsb.mvvm_rooomdb.NodeDao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hsb.mvvm_rooomdb.Model.userNode

@Dao
interface userDao {
    @Insert
    fun insert(node: userNode)

    @Query("SELECT * FROM users_tbl ORDER by id ASC")
    fun readall(): LiveData<List<userNode>>

    @Delete
    suspend fun delete_one(node: userNode)

    @Update
    suspend fun update_node(node: userNode)

    @Query("DELETE FROM users_tbl")
    suspend fun delete_all()
}