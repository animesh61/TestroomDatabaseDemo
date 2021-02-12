package com.app.testroomdatabasedemo.view

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.testroomdatabasedemo.R
import com.app.testroomdatabasedemo.adapter.RecylerAdapter
import com.app.testroomdatabasedemo.db.UserEntity
import com.app.testroomdatabasedemo.viewmodel.UserviewModel
import kotlinx.android.synthetic.main.row_user.*

class AddUserActivity: AppCompatActivity(),RecylerAdapter.Rowclicklistener {
    lateinit var viewmodel: UserviewModel
    lateinit var recylerviewadapter: RecylerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_user_activity)
        initview()
    }
    private fun initview(){
        val et_name=findViewById(R.id.et_name)as EditText
        val et_address=findViewById(R.id.et_address)as EditText
        val et_phone=findViewById(R.id.et_phone)as EditText
        val et_email=findViewById(R.id.et_email)as EditText
        val btn_save=findViewById(R.id.btn_save)as Button
      //  viewmodel= ViewModelProviders.of(this).get(UserviewModel::class.java)

        val rv_list=findViewById(R.id.rv_list)as RecyclerView
        rv_list.apply { layoutManager= LinearLayoutManager(this@AddUserActivity)
            recylerviewadapter= RecylerAdapter(this@AddUserActivity)
            adapter=recylerviewadapter
            val divider= DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
            addItemDecoration(divider)
        }
        viewmodel= ViewModelProviders.of(this).get(UserviewModel::class.java)
        viewmodel.getalluserobserver().observe(this, Observer {
            recylerviewadapter.setListdata(ArrayList(it))
            recylerviewadapter.notifyDataSetChanged()
        })


        btn_save.setOnClickListener {
            var name = et_name.text.toString()
            var address = et_address.text.toString()
            var phone=et_phone.text.toString()
            var email=et_email.text.toString()
            val user=UserEntity(0,name, address, phone, email)

            if (name.isEmpty()) {
                Toast.makeText(this, "please enter name", Toast.LENGTH_SHORT).show()
            }
            else if (address.isEmpty()) {
                Toast.makeText(this,"please enter address",Toast.LENGTH_SHORT).show()
            }
            else if(phone.isEmpty()){
                Toast.makeText(this,"please enter phone no",Toast.LENGTH_SHORT).show()

            }

            else if(!isValidEmail(email)){
                Toast.makeText(this,"please enter valid email ",Toast.LENGTH_SHORT).show()

            }
            else {
                viewmodel.insertuserinfo(user)
                Toast.makeText(this,"Insert Successfully! ",Toast.LENGTH_SHORT).show()


            }

        }

    }

    fun isValidEmail(target: CharSequence): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

    override fun onitemclicklistener(user: UserEntity) {
        tv_name.text=user.name
        tv_address.text=user.address
        tv_phone.text=user.phone
        tv_email.text=user.email
    }

}