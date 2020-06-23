package com.example.talentsoft_technical_test.ui.news_details

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.talentsoft_technical_test.ui.common.AsynchronousImageDownloadTask
import com.example.talentsoft_technical_test.ui.common.BaseViewModel
import com.example.talentsoft_technical_test.ui.news.model.ArticleUi


class NewsDetailsViewModel : BaseViewModel<ArticleUi>() {

    var clickOnArticleButton: View.OnClickListener? = null

    fun setArticleData(articleUi: ArticleUi, clickOnArticleButton: View.OnClickListener) {
        postUiData(articleUi)
        this.clickOnArticleButton = clickOnArticleButton
    }

    fun setClickOnArticleButton() {

    }

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["src"], requireAll = false)
        fun loadImage(imageView: ImageView, src: String?) {
            if (src != null) {
                AsynchronousImageDownloadTask(imageView).execute(src)
            }
        }
    }
}