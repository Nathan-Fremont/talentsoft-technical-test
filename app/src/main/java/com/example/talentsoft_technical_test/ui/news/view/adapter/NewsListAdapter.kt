package com.example.talentsoft_technical_test.ui.news.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.talentsoft_technical_test.R
import com.example.talentsoft_technical_test.ui.news.model.ArticleUi
import com.example.talentsoft_technical_test.ui.news.model.PageNewsListUi
import com.example.talentsoft_technical_test.ui.news.view.NewsViewHolder

class NewsListAdapter : ListAdapter<ArticleUi, NewsViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val holder = NewsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.holder_news, parent, false)
        )
        return holder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val articleUi = getItem(position)
        holder.bind(
            articleUi
        )
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ArticleUi>() {
            override fun areItemsTheSame(
                oldItem: ArticleUi,
                newItem: ArticleUi
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ArticleUi,
                newItem: ArticleUi
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}