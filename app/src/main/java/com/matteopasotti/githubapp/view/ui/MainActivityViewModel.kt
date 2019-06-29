package com.matteopasotti.githubapp.view.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matteopasotti.githubapp.model.GithubUser
import com.matteopasotti.githubapp.repository.GithubUserRepository
import com.matteopasotti.githubapp.view.adapter.GithubUserAdapter
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainActivityViewModel @Inject constructor(private val githubUserRepository: GithubUserRepository) : ViewModel() {

    lateinit var adapter : GithubUserAdapter

    /*private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)*/

    private val _users = MutableLiveData<List<GithubUser>>()
    val users: LiveData<List<GithubUser>> = _users

    fun getAllUsers() {
        viewModelScope.launch {
            _users.postValue(githubUserRepository.getAllUsers())
        }
    }

    // No need to override onCleared()

}