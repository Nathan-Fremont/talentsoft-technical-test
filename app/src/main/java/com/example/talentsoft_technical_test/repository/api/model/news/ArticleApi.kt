package com.example.talentsoft_technical_test.repository.api.model.news

data class ArticleApi(
    val source: ArticleSourceApi,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)
