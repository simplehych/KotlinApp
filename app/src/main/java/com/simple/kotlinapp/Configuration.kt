package com.simple.kotlinapp

/**
 * Created by hych on 2017/6/1 10:50
 */
class Configuration(map: Map<String, Any?>) {

    /**
     * 另外一个属性委托方式就是，属性的值会从一个map中湖区value，属性的名字对应这个map中的key。
     * 这个委托可以让我们做一些很强大的事情，因为我们可以很简单地从一个动态地map中创建一个对象实例
     */
    val width: Int by map
    val height: Int by map
    val dp: Int by map
    val deviceName: String by map

    val conf = Configuration(mapOf(
            "width" to 1080,
            "height" to 720,
            "dp" to 240,
            "deviceName" to "myDevice"
    ))
}