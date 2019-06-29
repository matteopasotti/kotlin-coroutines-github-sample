package com.matteopasotti.githubapp.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.matteopasotti.githubapp.R
import com.matteopasotti.githubapp.databinding.ActivityMainBinding
import com.matteopasotti.githubapp.factory.AppViewModelFactory
import com.matteopasotti.githubapp.view.adapter.GithubUserAdapter
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)
    }

    private val binding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main) }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)


        val linearLayout = androidx.recyclerview.widget.LinearLayoutManager(this)
        binding.listUsers.layoutManager = linearLayout
        viewModel.adapter = GithubUserAdapter()
        binding.listUsers.adapter = viewModel.adapter


        viewModel.users.observe(this, Observer { response ->
            if (response != null) {
                viewModel.adapter.updateList(response)
            }
        })

        viewModel.getAllUsers()
    }
}