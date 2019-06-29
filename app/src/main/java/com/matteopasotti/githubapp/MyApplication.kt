package com.matteopasotti.githubapp

import android.app.Activity
import android.app.Application
import com.matteopasotti.githubapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build().inject(this)
    }


    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}