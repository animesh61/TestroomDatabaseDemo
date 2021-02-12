package com.app.testroomdatabasedemo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.testroomdatabasedemo.db.RoomAppDb
import com.app.testroomdatabasedemo.db.UserEntity

class UserviewModel(app:Application):AndroidViewModel(app) {
    lateinit var alluser:MutableLiveData<List<UserEntity>>

    init {
        alluser= MutableLiveData()
    }
    fun getalluserobserver():MutableLiveData<List<UserEntity>>{
        return alluser
    }
    fun getalluser(){
        val userdao=RoomAppDb.getAppDatabase(getApplication())?.userdao()
        val list=userdao?.getuserinfo()
        alluser.postValue(list)
    }
    fun insertuserinfo(entity:UserEntity){
        val userdao=RoomAppDb.getAppDatabase(getApplication())?.userdao()
        userdao?.insertuser(entity)
        getalluser()


    }
}