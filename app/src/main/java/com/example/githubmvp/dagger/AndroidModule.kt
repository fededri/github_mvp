package com.example.githubmvp.dagger

import android.content.Context
import com.example.githubmvp.GithubApplication
import com.example.githubmvp.services.GithubUsersService
import dagger.Module
import dagger.Provides

/**
 * Created by Federico Torres on 4/8/17.
 */
@Module
class AndroidModule(private val application: GithubApplication) {

    @Provides
    fun provideApplicationContext(): Context{
        return application
    }

    @Provides @GithubAppScope
    fun provideGithubUserService(): GithubUsersService{
        return GithubUsersService()
    }


}