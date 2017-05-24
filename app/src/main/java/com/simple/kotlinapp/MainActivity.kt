package com.simple.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

/**
 * 在Kotlin中，一切都是对象，没有原始的基本类型
 */
class MainActivity : AppCompatActivity() {

    private val items = arrayListOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 1、as 强转      2、直接属性方式设置      3、省去new关键字
         */
        val forecastList = findViewById(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)

        toast();
        toast("hi")
        toast("hi", Toast.LENGTH_LONG)
    }

    /**
     * 函数给参数指定一个默认值使得它们变得可选
     */
    fun toast(msg: String = "Hello", time: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "${msg.length} + $msg", time).show()
    }
}
