package com.example.talentsoft_technical_test.ui.news

import com.example.talentsoft_technical_test.domain.usecase.GetNewsFromSourceUseCase
import com.example.talentsoft_technical_test.domain.usecase.GetNewsUseCase
import com.example.talentsoft_technical_test.repository.RepositoryImpl
import com.example.talentsoft_technical_test.repository.api.ApiDataSourceImpl
import com.example.talentsoft_technical_test.ui.common.BaseViewModel
import com.example.talentsoft_technical_test.ui.common.model.EnumArticleSource
import com.example.talentsoft_technical_test.ui.news.mapper.NewsListUiMapper
import com.example.talentsoft_technical_test.ui.news.model.PageNewsListUi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsListViewModel : BaseViewModel<PageNewsListUi>() {

    private val getNewsUseCase = GetNewsUseCase(RepositoryImpl(ApiDataSourceImpl()))
    private val getNewsFromSourceUseCase = GetNewsFromSourceUseCase(RepositoryImpl(ApiDataSourceImpl()))

    private val newsListUiMapper = NewsListUiMapper()

    init {
        getNews()
    }

    fun getNewsSources() : Array<String> {
        val sourcesList = arrayListOf("").apply {
            addAll(EnumArticleSource.values().map { it.sourceString })
        }
        return sourcesList.toTypedArray()
    }

    private fun getNews() {
        GlobalScope.launch {
            getNewsUseCase.invoke()
                .map { article ->
                    newsListUiMapper.toUi(article)
                }
                .let { articles ->
                    postUiData(PageNewsListUi(articles))
                }
        }
    }

    fun getNewsFromSource(position: Int) {
        val sourceList = getNewsSources()
        val source = sourceList[position]

        if (source.isEmpty()) {
            getNews()
        } else {
            GlobalScope.launch {
                getNewsFromSourceUseCase.invoke(source)
                    .map { article ->
                        newsListUiMapper.toUi(article)
                    }
                    .let { articles ->
                        postUiData(PageNewsListUi(articles))
                    }
            }
        }
    }
}