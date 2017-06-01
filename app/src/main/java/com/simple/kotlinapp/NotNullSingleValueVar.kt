package com.simple.kotlinapp

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by hych on 2017/6/1 11:10
 */
class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {

    /**
     * 创建一个notNull的委托，它只能被赋值一次，如果第二次赋值，它就会抛出异常。
     * Kotlin提供了几个接口，我们自己的委托必须要实现：ReadOnlyProperty和ReadWriteProperty。具体取决于我们被委托的对象是val还是var
     *
     * 1、创建一个类集成ReadWriteProperty
     * 2、这个委托可以作用在任何非null的类型，它接受任何类型的引用，然后像getter和setter那样使用T
     *      Getter函数 如果已经被初始化，则会返回一个值，否则会抛出异常
     *      Setter函数 如果仍然是null，则赋值，否则会抛异常
     * 3、创建一个对象，然后添加函数使用你自定义的委托
     *
     */

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException(" not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException(" already initialized")
    }

    object DelegatesExt {
        fun <T> notNullSingleValue():
                ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
    }
}