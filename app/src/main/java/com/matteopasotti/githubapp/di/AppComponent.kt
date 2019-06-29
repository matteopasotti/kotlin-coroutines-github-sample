package com.matteopasotti.githubapp.di

import android.app.Application
import com.matteopasotti.githubapp.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Suppress("unused")
@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (ViewModelModule::class),
    (ActivityModule::class),
    (AppModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }

    fun inject(instance: MyApplication)
}