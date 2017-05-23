package com.simple.kotlinapp

import java.util.ArrayList

/**
 * Created by hych on 2017/5/23 10:12
 */

class Test {


    var name: String = ""
        get() = field
        set(value) {
            field = "Name: $value"
        }
    var name1: String = ""
        get() = field
        set(value) {
            field = "Name: $value"
        }

    /**
     * 你需要知道一个有趣的概念，一切kotlin函数都会返回一个值。
     * 如果没有指定，它就默认返回一个Unit类。
     * 所以如果我们想让Command不返回数据，我们可以指定它的类型为Unit。
     */
    fun test(): Unit {
        val list = ArrayList<String>()
        list.add("1")
        list.add("2")

        val i: Int = 7
        val d: Double = i.toDouble()
    }

    fun oneTwo(): String {
        val a = 2
        if (a > 1) {
            return "1"
        } else {
            return a.toString() + ""
        }
    }

}
