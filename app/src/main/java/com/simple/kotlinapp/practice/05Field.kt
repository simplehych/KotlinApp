package com.simple.kotlinapp.practice

/**
 * Created by hych on 2017/5/25 08:51
 */
class `05Field` {

    init {
        val person = Person()
        person.name = "name"
        val name = person.name
    }

    class Person {
        /**
         * 直接使用类名打点使用，而不像java中的set/get方法，如果没有重写默认获取值，若需要重写如下
         */

        var name: String = ""

        var age: String = "20"
            get() = field
            set(value) {
                field = "age:$value"
            }
    }
}