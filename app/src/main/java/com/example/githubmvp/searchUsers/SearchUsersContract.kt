package com.example.githubmvp.searchUsers

import com.example.githubmvp.services.response.Item
import com.example.githubmvp.services.response.User

/**
 * Created by Federico Torres on 4/8/17.
 */
interface SearchUsersContract {

    interface View{
        fun addUsers(users : List<Item>)
        fun replaceUsers(users: List<Item>)
    }


    interface Presenter {
        fun setView( view : View)
        fun onTextInput(query : String)
        fun onDestroy()
    }


    interface  Model {

    }

}