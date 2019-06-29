package com.matteopasotti.githubapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.matteopasotti.githubapp.factory.AppViewModelFactory
import com.matteopasotti.githubapp.view.ui.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindMainActivityViewModel( mainActivityViewModel: MainActivityViewModel) : ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(appViewModelFactory: AppViewModelFactory) : ViewModelProvider.Factory
}