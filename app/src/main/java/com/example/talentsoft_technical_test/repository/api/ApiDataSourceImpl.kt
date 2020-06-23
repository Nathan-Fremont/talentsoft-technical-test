package com.example.talentsoft_technical_test.repository.api

import android.util.Log
import com.example.talentsoft_technical_test.repository.ApiDataSource
import com.example.talentsoft_technical_test.repository.api.model.news.ArticlesListApi
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class ApiDataSourceImpl : ApiDataSource {
    private val okHttpClient by lazy { OkHttpClient() }

    override fun getNews(): ArticlesListApi {
        val request = Request.Builder()
            .url(NEWS_URL)
            .build()
        val stringBody = okHttpClient.newCall(request).execute().body?.string()
        val articlesList = Gson().fromJson(stringBody, ArticlesListApi::class.java)
        Log.i("getNews", stringBody)
        return articlesList
    }

    companion object {
        private const val API_KEY = "f7d412f9c4fc4d2099550fccb20e35fb"
        private const val NEWS_URL = "http://newsapi.org/v2/top-headlines?country=fr&apiKey=${API_KEY}"
    }
}