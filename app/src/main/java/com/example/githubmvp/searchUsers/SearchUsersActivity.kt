package com.example.githubmvp.searchUsers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.githubmvp.R
import com.example.githubmvp.services.BaseActivity
import com.example.githubmvp.services.response.Item
import com.example.githubmvp.services.response.User
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class SearchUsersActivity : BaseActivity(),SearchUsersContract.View {


    @Inject
    lateinit var presenter : SearchUsersPresenter


     val adapter : UsersAdapter = UsersAdapter(this, listOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       component.inject(this)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
        presenter.setView(this)

        val searchObservable  =  RxTextView.textChanges(etSearch).subscribeOn(Schedulers.newThread())
                                    .observeOn(AndroidSchedulers.mainThread())

        searchObservable.subscribe(object : Observer<CharSequence>{
            override fun onError(e: Throwable) {
            }

            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: CharSequence) {
                presenter.onTextInput(t.toString())
            }
        })

    }


    override fun replaceUsers(users: List<Item>) {
        adapter.replaceUsers(users)
    }

    override fun addUsers(users: List<Item>) {
        adapter.addUsers(users)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}
