package com.example.talentsoft_technical_test.ui.news.mapper

import com.example.talentsoft_technical_test.domain.model.Article
import com.example.talentsoft_technical_test.ui.common.BaseUiMapper
import com.example.talentsoft_technical_test.ui.news.model.ArticleUi

class NewsListUiMapper : BaseUiMapper<Article, ArticleUi>() {

    override fun toUi(domain: Article): ArticleUi {
        val ui = ArticleUi(
            domain.author,
            domain.title,
            domain.description,
            domain.url,
            domain.urlToImage,
            domain.publishedAt,
            domain.content
        )
        return ui
    }
}