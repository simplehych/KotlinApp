package com.simple.kotlinapp

import android.util.Log
import java.net.URL

/**
 * Created by hych on 2017/5/23 13:26
 */
class Request(val url: String) {
    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }

}
