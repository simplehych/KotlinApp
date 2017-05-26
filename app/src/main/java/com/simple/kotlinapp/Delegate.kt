package com.simple.kotlinapp

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by hych on 2017/5/26 13:19
 *
 * 我们可能需要一个属性具有一些相同的行为，使用lazy或者observable可以被很有趣地实现重用。
 * 而不是一次又一次地声明那些相同的代码，Kotlin提供了一个委托属性到一个类的方法。这就我们知道的委托属性
 *
 */
class Delegate<T> : ReadWriteProperty<Any?, T> {

    /**
     * 这个T是委托属性的类型。
     * getValue函数接收一个类的引用和一个属性的元数据。
     * setValue函数又接收了一个被设置的值。
     * 如果这个属性是不可修改(val),就会只有一个getValue函数
     */

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        TODO()
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    }
}

/**
 * 属性委托是怎么设置的
 * 使用by关键字来指定一个委托对象
 */
class Example {
    var p: String by Delegate()
}