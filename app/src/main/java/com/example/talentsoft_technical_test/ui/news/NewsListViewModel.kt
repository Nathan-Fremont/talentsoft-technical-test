package com.example.talentsoft_technical_test.ui.news

import com.example.talentsoft_technical_test.domain.usecase.GetNewsUseCase
import com.example.talentsoft_technical_test.repository.RepositoryImpl
import com.example.talentsoft_technical_test.repository.api.ApiDataSourceImpl
import com.example.talentsoft_technical_test.ui.common.BaseViewModel
import com.example.talentsoft_technical_test.ui.news.mapper.NewsListUiMapper
import com.example.talentsoft_technical_test.ui.news.model.PageNewsListUi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsListViewModel : BaseViewModel<PageNewsListUi>() {

    private val getNewsUseCase = GetNewsUseCase(RepositoryImpl(ApiDataSourceImpl()))
    private val newsListUiMapper = NewsListUiMapper()

    init {
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
}