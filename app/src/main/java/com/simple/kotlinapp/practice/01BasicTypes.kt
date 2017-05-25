package com.simple.kotlinapp.practice

/**
 * Created by hych on 2017/5/24 09:59
 */
class `01BasicTypes` : Any() {

    /**
     * 一切皆对象，像Java中的基本数据类型存在，但是它们全都会作为对象存在
     */
    init {

    }

    /**
     * 数字类型中不会自动转型，必须要做一个明确的类型转换
     */
    fun convert() {
        //不能给Double变量分配一个Int，必须明确
        val i1: Int = 7
        val d1: Double = i1.toDouble()

        //字符明确转Int
        val c1: Char = 'c'
        val i2: Int = c1.toInt()

        //位运算
        val FLAG1: Int = 0
        val FLAG2: Int = 1
        val bitwiseOr = FLAG1 or FLAG2
        val bitwiseAnd = FLAG1 and FLAG2

        //字面上可以写明具体的类型，这个不是必须的，但是一个通用的Kotlin实践时可以省略变量的类型，让编译器自己去推断出具体类型
        val i3 = 12
        val i3Hex = 0x0f
        val l3 = 3L
        val d3 = 3.5
        val f3 = 3.5F

        //一个String可以像数组那样访问
        val s4 = "Example"
        val c4 = s4[2]  //一个字符
//        val s4 = "Example"  //报错重复，貌似不能迭代
        for (c in s4) {
            print(c)
        }
    }
}