package com.app.testroomdatabasedemo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT *FROM userinfo ORDER BY id DESC")
    fun getuserinfo():List<UserEntity>?
    @Insert
    fun insertuser(user:UserEntity?)
}