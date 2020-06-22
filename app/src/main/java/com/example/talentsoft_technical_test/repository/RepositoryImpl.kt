package com.example.talentsoft_technical_test.repository

import com.example.talentsoft_technical_test.domain.Repository
import com.example.talentsoft_technical_test.domain.model.Article
import com.example.talentsoft_technical_test.repository.api.model.news.ArticlesListApi

class RepositoryImpl(
    private val apiDataSource: ApiDataSource
) : Repository {

    override fun getNews(url: String): List<Article> {
        return apiDataSource.getNews(url).articles.map { articleApi ->
            Article(
                articleApi.author,
                articleApi.title,
                articleApi.description,
                articleApi.url,
                articleApi.urlToImage,
                articleApi.publishedAt,
                articleApi.content
            )
        }
    }
}