package com.app.testroomdatabasedemo.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.app.testroomdatabasedemo.R

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initview()
    }
    private fun initview(){
      val btn_add_user=findViewById(R.id.btn_add_user)as Button
      //  val btn_user_list=findViewById(R.id.btn_user_list)as Button

        btn_add_user.setOnClickListener {
            var intent: Intent = Intent(this, AddUserActivity::class.java)
            startActivity(intent)

        }


    }


}