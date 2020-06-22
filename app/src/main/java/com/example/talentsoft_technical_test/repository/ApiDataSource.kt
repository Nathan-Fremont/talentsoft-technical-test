package com.example.talentsoft_technical_test.repository

import com.example.talentsoft_technical_test.repository.api.model.news.ArticlesListApi

interface ApiDataSource {
    fun getNews(url: String): ArticlesListApi
}