package com.example.talentsoft_technical_test.repository.api.model.news

data class ArticlesListApi(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleApi>
)