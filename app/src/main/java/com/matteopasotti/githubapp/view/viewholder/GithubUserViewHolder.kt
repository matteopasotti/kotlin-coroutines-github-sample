package com.matteopasotti.githubapp.view.viewholder

import android.view.View
import androidx.databinding.DataBindingUtil
import com.matteopasotti.githubapp.databinding.ItemGithubUserBinding
import com.matteopasotti.githubapp.model.GithubUser

class GithubUserViewHolder( view : View) : BaseViewHolder(view) {

    private lateinit var user : GithubUser

    private val binding by lazy { DataBindingUtil.bind<ItemGithubUserBinding>(view) }


    override fun bindData(data: Any?) {
        if( data is GithubUser) {
            user = data
            drawUI()
        }
    }

    override fun onClick(v: View?) {
    }

    private fun drawUI() {
        binding.apply {
            binding?.user = user
            binding?.executePendingBindings()
        }
    }
}