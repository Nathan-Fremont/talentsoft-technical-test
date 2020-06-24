package com.example.talentsoft_technical_test.domain.usecase

import com.example.talentsoft_technical_test.domain.Repository
import com.example.talentsoft_technical_test.domain.model.Article

class GetNewsFromSourceUseCase(
    private val repository: Repository
) {
    operator fun invoke(source: String): List<Article> {
        return repository.getNewsFromSource(source)
    }
}