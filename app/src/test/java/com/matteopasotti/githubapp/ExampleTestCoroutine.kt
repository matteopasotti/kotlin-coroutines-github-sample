package com.matteopasotti.githubapp

import com.matteopasotti.githubapp.api.GithubService
import com.matteopasotti.githubapp.model.GithubUser
import com.matteopasotti.githubapp.repository.GithubUserRepository
import com.matteopasotti.githubapp.view.ui.MainActivityViewModel
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response


@RunWith(JUnit4::class)
class ExampleTestCoroutine {

    @Mock
    lateinit var apiService: GithubService

    lateinit var githubUserRepository: GithubUserRepository

    lateinit var viewModel: MainActivityViewModel


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.githubUserRepository = GithubUserRepository(apiService)
        this.viewModel = MainActivityViewModel(this.githubUserRepository)
    }

    @Test
    fun getGithubUsersTest() {
        val users: Response<List<GithubUser>> = Response.success(listOf())
        val service = mock<GithubService> {
            on { apiService.getAllUsers() } doReturn users.toDeferred()
        }
    }

    @Test
    fun `calls getAllUsers in GithubService, then it returns a `() {
        val users: Response<List<GithubUser>> = Response.success(listOf())
        `when`(apiService.getAllUsers()).thenReturn(users.toDeferred())
    }
}