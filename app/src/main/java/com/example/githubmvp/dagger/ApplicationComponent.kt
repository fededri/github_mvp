package com.example.githubmvp.dagger

import com.example.githubmvp.searchUsers.SearchUsersActivity
import dagger.Component

/**
 * Created by Federico Torres on 4/8/17.
 */

@GithubAppScope
@Component(modules = arrayOf(AndroidModule::class))
interface ApplicationComponent {
    fun inject(searchActivity: SearchUsersActivity)
}