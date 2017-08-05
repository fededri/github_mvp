package com.example.githubmvp.searchUsers

/**
 * Created by Federico Torres on 4/8/17.
 */
interface SearchUsersContract {

    interface View{

    }


    interface Presenter {
        fun setView( view : View)
        fun onTextInput(query : String)
    }


    interface  Model {

    }

}