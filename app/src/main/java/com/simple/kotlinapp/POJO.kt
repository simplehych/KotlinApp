package com.simple.kotlinapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import java.util.*

/**
 * Created by hych on 2017/5/25 13:45
 */
data class ForecastTest(val date: Date, val temperature: Float, val details: String)

data class ForecastResult(val city: City, val list: List<Forecast>)

data class City(val id: Long, val name: String, val coord: Coordinates,
                val country: String, val population: Int)

data class Coordinates(val lon: Float, val lat: Float)

data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float,
                    val humidity: Int, val weather: List<Weather>,
                    val speed: Float, val deg: Int, val clouds: Int,
                    val rain: Float)

data class Temperature(val day: Float, val min: Float, val max: Float,
                       val night: Float, val eve: Float, val morn: Float)

data class Weather(val id: Long, val main: String, val description: String,
                   val icon: String)

/**
 * 当我们使用Gson来解析json到我们的类中，这些属性的名字必须要与json中的名字一样，或者可以指定一个Serialised name(序列化名称)
 * 一个好的实践是，大部分软件结构中会根据我们app中布局来解耦或不同的模型。所以我喜欢使用声明简化这些类，因为
 * 我会在app其他部分使用它之前解析这些类。属性名称与json结果总的名字是完全一样的
 *
 */
