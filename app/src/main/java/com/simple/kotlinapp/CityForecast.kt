package com.simple.kotlinapp

import java.util.*

/**
 * Created by hych on 2017/6/2 11:02
 */
class CityForecast(val map: MutableMap<String, Any?>,
                   val dailyForecast: List<DayForecast>) {
    var _id: Long by map
    var city: String by map
    var country: String by map

    /**
     * 默认的构造函数会得到一个含有属性和对应的值的map，和一个dailyForecast。多亏了委托，这些值
     * 会根据key的名字映射到相应的属性中去，如果我们希望映射的过程运行完美，那么属性的名字必须要
     * 和数据库中中对应的名字一模一样。
     * 但是，蝶儿中构造函数也是必需的。这是因为我们需要从domain映射到数据库类中，所以不能使用map，
     * 从属性中设置值也是方便的。我们传入一个空的map，但是有一次，多亏了委托，当我们设置值的属性的时候，
     * 它会自动增加所有的值的map中，用这种方式，我们就准备好map来保存数据库中，使用了这些代码，我将会
     * 看到它想魔法一样神奇
     */


    constructor(id: Long, city: String, country: String,
                dailyForecast: List<DayForecast>)
            : this(HashMap(), dailyForecast) {
        this._id = id
        this.city = city
        this.country = country
    }

}

class DayForecast(var map: MutableMap<String, Any?>) {
    var _id: Long by map
    var date: Long by map
    var description: String by map
    var high: Int by map
    var low: Int by map
    var iconUrl: String by map
    var cityId: Long by map

    constructor(date: Long, description: String, high: Int, low: Int,
                iconUrl: String, cityId: Long)
            : this(HashMap()) {
        this.date = date
        this.description = description
        this.high = high
        this.low = low
        this.iconUrl = iconUrl
        this.cityId = cityId
    }
}
