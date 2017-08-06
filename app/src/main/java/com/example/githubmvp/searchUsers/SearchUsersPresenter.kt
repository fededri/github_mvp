package com.example.githubmvp.searchUsers

import android.util.Log
import com.example.githubmvp.services.response.SearchUsersResponse
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
    val disposables : MutableList<Disposable> = mutableListOf()

    override fun setView(view: SearchUsersContract.View) {
        mView = view
    }

    val TAG = "SearchPresenter"

    override fun onTextInput(query: String) {
        val observable =  mModel.getUsers(query)

        observable.subscribe(object : Observer<SearchUsersResponse> {
            override fun onComplete() {
                Log.i(TAG,"Completed")
            }

            override fun onSubscribe(d: Disposable) {
                disposables.add(d)
            }

            override fun onNext(t: SearchUsersResponse) {
                if(t.items != null)
                mView.replaceUsers(t.items)
            }

            override fun onError(e: Throwable) {
                Log.e(TAG,"Error")
            }
        })

    }


    override fun onDestroy() {
        for(d in disposables){
            d.dispose()
            disposables.remove(d)
        }
    }
}