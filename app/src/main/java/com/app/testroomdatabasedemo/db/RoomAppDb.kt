package com.app.testroomdatabasedemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class],version = 1,exportSchema = false)
abstract class RoomAppDb:RoomDatabase() {
    abstract fun userdao():UserDao?
    companion object{
        private var instance:RoomAppDb?=null
        fun getAppDatabase(context:Context):RoomAppDb?{
            if(instance==null){
                instance= Room.databaseBuilder<RoomAppDb>(context.applicationContext,RoomAppDb::class.java,"AppDb").allowMainThreadQueries().build()

            }
            return instance
        }
    }
}