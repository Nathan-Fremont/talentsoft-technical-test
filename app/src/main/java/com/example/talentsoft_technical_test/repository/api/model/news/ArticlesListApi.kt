package com.example.talentsoft_technical_test.repository.api.model.news

import com.example.talentsoft_technical_test.repository.api.model.news.ArticleApi

data class ArticlesListApi(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleApi>
)