package com.example.githubmvp.searchUsers

import com.example.githubmvp.services.response.User
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Federico Torres on 4/8/17.
 */


class SearchUsersPresenter @Inject constructor(githubUsersModel: SearchUsersModel): SearchUsersContract.Presenter {



    lateinit var mView : SearchUsersContract.View
    val mModel = githubUsersModel

    override fun setView(view: SearchUsersContract.View) {
        mView = view

    }


    override fun onTextInput(query: String) {
        val observable =  mModel.getUsers(query)

        observable.subscribe(object : Observer<List<User>> {
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: List<User>) {

            }

            override fun onError(e: Throwable) {
            }
        })

    }
}