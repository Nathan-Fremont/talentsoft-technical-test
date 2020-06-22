package com.example.talentsoft_technical_test.domain.model

import com.example.talentsoft_technical_test.repository.api.model.news.ArticleApi
import com.example.talentsoft_technical_test.repository.api.model.news.ArticleSourceApi

class Article(
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)
