package com.example.talentsoft_technical_test.ui.news.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.talentsoft_technical_test.ui.common.AsynchronousImageDownloadTask
import com.example.talentsoft_technical_test.ui.news.model.ArticleUi
import kotlinx.android.synthetic.main.holder_news.view.*

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(articleUi: ArticleUi) {
        itemView.apply {
            holder_news_title.text = articleUi.title
            AsynchronousImageDownloadTask(holder_news_image).execute(articleUi.urlToImage)
        }
    }
}