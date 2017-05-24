package com.simple.kotlinapp.practice

/**
 * Created by hych on 2017/5/24 09:06
 */

class Person(name: String, surname: String) : Animal(name) {
    /**
     * 构造函数的函数体
     */
    init {
        //TODO 执行父构造体，super的顺序？？
    }

    /**
     * 函数fun，先写参数名然后规定类型
     */
    fun add(x: Int, y: Int): Int {
        return x + y;
    }

    /**
     * 类默认继承Any，而方法不写情况默认返回Unit，和Java的void类似，但是Unit是一个真正的对象
     */
    fun add1(x: Int, y: Int): Unit {}

    /**
     * 和上方法一致
     */
    fun add2(x: Int, y: Int) {}

    /**
     * 当返回的结果可以使用一个表达式计算出来，你可以不使用括号，而使用等号
     */
    fun add3(x: Int, y: Int): Int = x + y

}


