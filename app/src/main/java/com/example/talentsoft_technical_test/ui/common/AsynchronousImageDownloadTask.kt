package com.example.talentsoft_technical_test.ui.common

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import java.io.InputStream
import java.net.URL


class AsynchronousImageDownloadTask(bmImage: ImageView?) : AsyncTask<String, Void, Bitmap>() {
    private var bmImage: ImageView? = null

    init {
        this.bmImage = bmImage
    }

    override fun doInBackground(vararg urls: String?): Bitmap? {
        val urldisplay = urls[0]
        var bmp: Bitmap? = null
        try {
            val `in`: InputStream = URL(urldisplay).openStream()
            bmp = BitmapFactory.decodeStream(`in`)
        } catch (e: Exception) {
            Log.e("Error", e.message ?: "Unknown error while asynchronously loading image")
            e.printStackTrace()
        }
        return bmp
    }

    override fun onPostExecute(result: Bitmap?) {
        bmImage?.setImageBitmap(result)
    }
}