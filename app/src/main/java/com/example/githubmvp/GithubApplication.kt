package com.example.githubmvp

import android.app.Application
import com.example.githubmvp.dagger.AndroidModule
import com.example.githubmvp.dagger.ApplicationComponent
import com.example.githubmvp.dagger.DaggerApplicationComponent

/**
 * Created by Federico Torres on 4/8/17.
 */
class GithubApplication : Application(){

    lateinit var component : ApplicationComponent

    override fun onCreate() {
        super.onCreate()


       component = DaggerApplicationComponent.builder().androidModule(AndroidModule(this)).build()


    }

}