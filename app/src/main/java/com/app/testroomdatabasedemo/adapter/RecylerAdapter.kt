package com.app.testroomdatabasedemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.testroomdatabasedemo.R
import com.app.testroomdatabasedemo.db.UserEntity

class RecylerAdapter(val listener:Rowclicklistener):RecyclerView.Adapter<RecylerAdapter.MyviewHolder>() {
    var items=ArrayList<UserEntity>()
    fun setListdata(data:ArrayList<UserEntity>){
        this.items=data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val inflator=LayoutInflater.from(parent.context).inflate(R.layout.row_user,parent,false)
        return MyviewHolder(inflator,listener)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.itemView.setOnClickListener { listener.onitemclicklistener(items[position]) }
        holder.bind(items[position])

    }

    class MyviewHolder(view:View,val listener:Rowclicklistener):RecyclerView.ViewHolder(view){
        val  tv_name:TextView=view.findViewById(R.id.tv_name)
        val  tv_address:TextView=view.findViewById(R.id.tv_address)
        val  tv_phone:TextView=view.findViewById(R.id.tv_phone)
        val  tv_email:TextView=view.findViewById(R.id.tv_email)
        fun bind(data:UserEntity){
            tv_name.text=data.name
            tv_address.text=data.address
            tv_phone.text=data.phone
            tv_email.text=data.email


        }
    }

    interface Rowclicklistener{
        fun onitemclicklistener(user:UserEntity)
    }

}