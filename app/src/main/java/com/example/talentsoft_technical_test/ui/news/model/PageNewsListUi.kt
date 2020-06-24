package com.example.talentsoft_technical_test.ui.news.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class PageNewsListUi(
    val newsList: List<ArticleUi>
)

@Parcelize
data class ArticleUi(
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
) : Parcelable