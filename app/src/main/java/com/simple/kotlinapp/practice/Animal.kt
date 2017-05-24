package com.simple.kotlinapp.practice

/**
 * Created by hych on 2017/5/24 09:09
 */
open class Animal(name: String) : Any(){
    init {

    }
}
/**
 * 1、默认任何类都是基础继承自Any(与Java中的Object)
 * 2、所有的类默认是不可继承的(final),所以我们只能继承哪些明确声明open或者abstract的类
 */
