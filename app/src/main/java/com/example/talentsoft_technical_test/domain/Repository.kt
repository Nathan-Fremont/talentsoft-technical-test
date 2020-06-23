package com.example.talentsoft_technical_test.domain

import com.example.talentsoft_technical_test.domain.model.Article

interface Repository {
    fun getNews(): List<Article>
}