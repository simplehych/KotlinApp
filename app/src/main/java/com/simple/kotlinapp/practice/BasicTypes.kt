package com.simple.kotlinapp.practice

/**
 * Created by hych on 2017/5/24 09:59
 */
class BasicTypes() : Any() {

    /**
     * 一切皆对象，像Java中的基本数据类型存在，但是它们全都会作为对象存在
     */
    init {

    }

    /**
     * 数字类型中不会自动转型，你不能
     */
    fun convert() {
        val i: Int = 7;
    }
}