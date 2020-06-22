package com.example.talentsoft_technical_test.ui.news.model

import com.example.talentsoft_technical_test.repository.api.model.news.ArticleSourceApi
import com.example.talentsoft_technical_test.repository.api.model.news.ArticlesListApi

data class PageNewsListUi(
    val newsList: List<ArticleUi>
)

data class ArticleUi(
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)