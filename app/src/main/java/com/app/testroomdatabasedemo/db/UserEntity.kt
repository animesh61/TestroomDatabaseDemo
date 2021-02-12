package com.app.testroomdatabasedemo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="userinfo")
data class UserEntity(@PrimaryKey (autoGenerate = true) @ColumnInfo(name = "id")val id:Int=0,
     @ColumnInfo(name="name")val name:String,
     @ColumnInfo(name = "address")val address:String,
     @ColumnInfo(name="phone") val phone:String,
     @ColumnInfo(name="email")val email:String){

}


