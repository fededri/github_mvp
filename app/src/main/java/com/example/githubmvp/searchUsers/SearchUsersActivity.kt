package com.example.githubmvp.searchUsers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.githubmvp.R
import com.example.githubmvp.services.BaseActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class SearchUsersActivity : BaseActivity() {


    @Inject
    lateinit var presenter : SearchUsersPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       component.inject(this)

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



}
