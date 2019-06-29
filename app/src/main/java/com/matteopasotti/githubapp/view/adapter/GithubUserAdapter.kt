package com.matteopasotti.githubapp.view.adapter

import android.view.View
import com.matteopasotti.githubapp.R
import com.matteopasotti.githubapp.model.GithubUser
import com.matteopasotti.githubapp.view.viewholder.BaseViewHolder
import com.matteopasotti.githubapp.view.viewholder.GithubUserViewHolder

class GithubUserAdapter : BaseAdapter() {

    init {
        addItems(ArrayList<GithubUser>())
    }

    fun updateList( users : List<GithubUser>) {
        addItems(users)
        notifyItemInserted(items.size)
    }


    override fun layout(item: Any?): Int {
        return R.layout.item_github_user
    }

    override fun viewHolder(layout: Int, view: View): BaseViewHolder {
        return GithubUserViewHolder(view)
    }
}