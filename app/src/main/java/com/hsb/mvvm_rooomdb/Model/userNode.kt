package com.hsb.mvvm_rooomdb.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_tbl")

data class userNode(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var firstname: String,
    var lastname: String
)