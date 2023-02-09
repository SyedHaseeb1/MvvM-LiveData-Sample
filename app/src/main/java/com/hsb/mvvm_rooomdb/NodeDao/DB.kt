package com.hsb.mvvm_rooomdb.NodeDao

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hsb.mvvm_rooomdb.Model.userNode

@Database(
    entities = [userNode::class],
    version = 1,
    exportSchema = true
)
abstract class DB : RoomDatabase() {
    abstract fun userDao(): userDao

    companion object {
        @Volatile
        private var INSTANCE: DB? = null
        fun getDB(context: Context): DB {
            val tempInst = INSTANCE
            if (tempInst != null) {
                return tempInst
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DB::class.java,
                    "users_tbl"
                ).build()
                INSTANCE = instance
                Log.e("DB","$instance pata ni")
                return instance
            }
        }
    }
}