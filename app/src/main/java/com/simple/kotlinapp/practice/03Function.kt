package com.simple.kotlinapp.practice

import android.content.Context

/**
 * Created by hych on 2017/5/24 09:06
 */

class `03Function`(name: String, surname: String) {

    /**
     * https://github.com/wangjiegulu/kotlin-for-android-developers-zh/blob/master/kuo_zhan_han_shu.md
     *
     * 扩展函数是指在一个类上增加一个新的行为，甚至我们没有这个类代码的访问权限。
     * 这是一个在稀少有用函数的类上扩展的方法。
     * 在java中，通常会实现很多带有static方法的工具类。
     * 早Kotlin中扩展函数的一个优势是我们不需要在调用方法的时候把整个对象当做参数传入。
     * 扩展函数变现的像是属于这个类的一样，而且我们可以使用this关键字调用所有public方法
     *
     * 扩展函数也可以是一个属性，通过相似的方法来扩展属性
     *
     * Kotlin互操作性
     * 扩展函数并不是真正的修改原来的类，它是以静态导入的方式来实现的。扩展函数可以被声明在任何文件中，
     * 因此有个通用的时间是把一系列有关的函数放在一个新建的文件里
     */


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


