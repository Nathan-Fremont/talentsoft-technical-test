package com.example.talentsoft_technical_test.repository.api

import android.util.Log
import com.example.talentsoft_technical_test.repository.ApiDataSource
import com.example.talentsoft_technical_test.repository.api.model.news.ArticlesListApi
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

class ApiDataSourceImpl : ApiDataSource {
    private val okHttpClient by lazy { OkHttpClient() }

    override fun getNews(): ArticlesListApi {
        val request = Request.Builder()
            .url(URL_NEWS_ALL)
            .build()
        val stringBody = okHttpClient.newCall(request).execute().body?.string()
        val articlesList = Gson().fromJson(stringBody, ArticlesListApi::class.java)
        Log.i("getNews", stringBody)
        return articlesList
    }

    override fun getNewsFromSource(source: String): ArticlesListApi {
        val request = Request.Builder()
            .url(URL_NEWS_FROM_SOURCE + source)
            .build()
        val stringBody = okHttpClient.newCall(request).execute().body?.string()
        val articlesList = Gson().fromJson(stringBody, ArticlesListApi::class.java)
        Log.i("getNewsFromSource", stringBody)
        return articlesList
    }

    companion object {
        private const val API_KEY = "f7d412f9c4fc4d2099550fccb20e35fb"
        private const val URL_NEWS_ALL = "http://newsapi.org/v2/top-headlines?country=fr&apiKey=${API_KEY}"
        private const val URL_NEWS_FROM_SOURCE = "http://newsapi.org/v2/top-headlines?apiKey=${API_KEY}&sources="
    }
}