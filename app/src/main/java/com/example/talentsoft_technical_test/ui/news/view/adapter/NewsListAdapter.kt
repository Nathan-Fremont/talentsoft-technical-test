package com.example.talentsoft_technical_test.ui.news.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.talentsoft_technical_test.R
import com.example.talentsoft_technical_test.ui.news.model.ArticleUi
import com.example.talentsoft_technical_test.ui.news.view.NewsViewHolder

class NewsListAdapter(val clickOnHolderCallback: ((articleUi: ArticleUi) -> Unit)) : ListAdapter<ArticleUi, NewsViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_news, parent, false)
        val holder = NewsViewHolder(
            view
        ).apply {
            itemView.setOnClickListener {
                val articleUi = getItem(adapterPosition)
                clickOnHolderCallback(articleUi)
            }
        }
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