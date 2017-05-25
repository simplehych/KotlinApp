package com.simple.kotlinapp

import java.net.URL

/**
 * Created by hych on 2017/5/25 09:43
 */
class Request(val url: String) {
    /**
     *  readText是Kotlin标准库中的扩展函数，这个函数不推荐结果很大的相应
     *  如果用这些代码去比较java，会发现节省了大量代码
     *  比如HttpURLConnection、BufferedReader和需要达到相同效果所必要的迭代，管理连接状态、reader等部分代码，
     *  很明显这些是场景背后所做的事情
     *  添加权限AndroidManifest.xml     <uses-permission android:name="android.permission.INTERNET" />
     */
    public fun run() {
        val forecastJsonStr = URL(url).readText()
    }
}