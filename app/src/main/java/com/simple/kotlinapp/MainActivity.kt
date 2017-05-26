package com.simple.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import org.jetbrains.anko.async
import org.jetbrains.anko.asyncResult
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread
import java.util.*

import kotlinx.android.synthetic.main.activity_main.*

/**
 * 在Kotlin中，一切都是对象，没有原始的基本类型
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * 1、as 强转      2、直接属性方式设置      3、省去new关键字
         * 使用了插件手动导入，可以不再使用findid的形式，但是要保证id和Xml文件一致
         * import kotlinx.android.synthetic.main.activity_main.*
         */
        //        val forecastList = findViewById(R.id.forecast_list) as RecyclerView
        //        val forecastList: RecyclerView = find(R.id.forecast_list)   //简洁，此为使用了Anko，上行未使用
        forecastList.layoutManager = LinearLayoutManager(this)

        /**
         * Anko提供了非常简单的DSL来处理异步任务，它满足大部分的需求。它提供了一个基本的async函数用于在其它线程执行代码，
         * 也可以选择通过调用uiThread的方式回到主线程
         *
         * UIThread有一个很不错的带你就是可以依赖调用者，如果它是被一个Activity调用的，那么吐过activity.isFinishing()返回true，
         * 则uiThread就不会执行，这样就不会在Activity销毁的时候遇到崩溃的情况了。
         *
         * 假如你想使用Future来工作，async返回一个java future。而且如果你需要一个返回结果的Future，你可以使用asyncResult
         */
        async() {
            //            val url = "http://www.baidu.com"
            //            Request(url).run()
            //            uiThread { longToast("Request performed") }
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result) { toast(it.date) }
            }
        }

        asyncResult {

        }

        /**
         * 复制一个数据类,如下我们拷贝了第一个forecast对象然后只修改了temperature的属性而没有修改这个对象其他状态
         *
         * 当使用Java类时小心“不可修改性”
         *      如果你决定使用不可修改来工作，你需要意识到java不是根据这种思想来设计的，在某些情况下，我们仍然可以修改这些状态，
         *      在该例子中，我们可以访问Date对象，然后改变它的值，有个简单的方法时记住所有需要修改状态的对象作为一个对着，然后必要的时候去拷贝一份
         *
         *      另一个方法是封装这些类，你可以创建一个ImmutableData类，它封装了Date并且不允许去修改它们的状态
         *
         */
        val f1 = ForecastTest(Date(), 27.5f, "Shiny day")
        val f2 = f1.copy(temperature = 30f)

        /**
         * 映射对象到变量中
         * 映射对象的每一个属性到变量中，这个过程就我们知道的多声明
         * 下面的多声明会被编译成下面的代码
         *      val date = f1.component1()
         *      val temperature = f1.component2()
         *      val details = f1.component2()
         */
        val (date, temperature, details) = f1
        val map = HashMap<Any, Any>()
        for ((key, value) in map) {
            Log.e("Simple", "key:$key,value:$value")
        }
    }

    /**
     * 函数给参数指定一个默认值使得它们变得可选
     */
    fun toast(msg: String = "Hello", time: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "${msg.length} + $msg", time).show()
    }
}
