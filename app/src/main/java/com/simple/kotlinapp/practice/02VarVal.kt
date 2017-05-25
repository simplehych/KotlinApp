package com.simple.kotlinapp.practice

import android.app.Activity
import android.content.Context

/**
 * Created by hych on 2017/5/25 08:35
 */
class `02VarVal` : Any() {

    /**
     * 变量可以很简单地定义成可变var和不可变val的变量，这个与java中使用final很相似，
     * 但是不可变在Kotlin是一个很重要的概念
     *
     * 一个不可变对象意味着在实例化后就不能再去改变它的状态了。如果你需要一个这个对象修改之后的版本，
     * 那就会再创建一个新的对象，这个让编程更有健壮性和预估性。在java中，大部分对象是可变的，那就意味着
     * 任何可以访问它这个对象的代码可以去修改它，从而影响整个程序的其他地方
     *
     * 不可变对象也可以说是线程安全的，因为他们无法去改变，也不需要去定义访问控制，因为所有线程访问的对象都是同一个
     *
     * 所以在Kotlin中，如果我们想使用不可变性，我们编码时思考的方式需要有一些改变，一个重要的概念，尽可能使用val。
     *
     */
    init {
        val s = "Example"
        val i = 23
//        val actionBar = supportActionBar
        //如果我们需要使用更多的泛型类型，则需要指定
        val a: Any = 23
//        val c: Context = activity
    }

}