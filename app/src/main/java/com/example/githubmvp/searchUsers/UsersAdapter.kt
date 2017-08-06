package com.example.githubmvp.searchUsers

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.githubmvp.R
import com.example.githubmvp.services.response.Item
import com.example.githubmvp.services.response.User
import com.infinixsoft.plora.loadImage

/**
 * Created by Federico Torres on 6/8/17.
 */
class UsersAdapter constructor(val context : Context, users: List<Item>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {


    var users = users.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.user_item_layout,null)

        val vh = ViewHolder(v)
        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        if(holder != null){
            holder.tvName.text = users[position].login
            holder.imageView.loadImage(users[position].avatarUrl)
        }
    }

    override fun getItemCount(): Int {
       return  users.size
    }


    fun replaceUsers(newUsers: List<Item>){
        users = newUsers.toMutableList()
        notifyDataSetChanged()

    }


    fun addUsers(list : List<Item>){
        for(user in list){
            addUser(user)
        }
    }



    private fun addUser(user: Item){
        users.add(user)
        notifyItemInserted(users.size-1)
    }


    open class ViewHolder(v: View) : RecyclerView.ViewHolder(v){

        val view = v

        val imageView = v.findViewById<ImageView>(R.id.imageView)
        val tvName = v.findViewById<TextView>(R.id.name)

    }
}