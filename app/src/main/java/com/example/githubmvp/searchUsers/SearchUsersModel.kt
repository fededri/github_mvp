package com.example.githubmvp.searchUsers

import com.example.githubmvp.services.GithubUsersService
import com.example.githubmvp.services.response.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Federico Torres on 4/8/17.
 */
class SearchUsersModel @Inject constructor(usersService : GithubUsersService) : SearchUsersContract.Model {

    val api = usersService.serviceClient

    fun getUsers(query : String): Observable<List<User>> {
        return api.searchUsers(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .flatMapIterable { response -> response.users }
                .toList()
                .toObservable()
    }

}