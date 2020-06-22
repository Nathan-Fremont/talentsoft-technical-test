package com.example.talentsoft_technical_test.domain.usecase

import com.example.talentsoft_technical_test.domain.Repository
import com.example.talentsoft_technical_test.domain.model.Article

class GetNewsUseCase(
    private val repository: Repository
) {
    operator fun invoke(): List<Article> {
        return repository.getNews("")
    }
}