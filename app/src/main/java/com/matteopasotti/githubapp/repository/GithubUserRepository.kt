package com.matteopasotti.githubapp.repository

import com.matteopasotti.githubapp.api.GithubService
import com.matteopasotti.githubapp.model.GithubUser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubUserRepository @Inject constructor(val githubApi: GithubService) : BaseRepository() {


    suspend fun getAllUsers() : MutableList<GithubUser>? {

        val usersResponse = safeApiCall(
            call = {githubApi.getAllUsers().await()},
            errorMessage = "Error fetching Users"
        )

        return usersResponse?.toMutableList()
    }
}