package com.simple.kotlinapp.practice

/**
 * Created by hych on 2017/6/6 08:48
 */
class `07Null` {
    /**
     * 可null类型怎么工作
     * 大部分现代语言使用某些方法去解决了这个问题，Kotlin的方法跟别的相似的语言相比是相当的另类
     * 和不同的。但是黄金准则还是一样，如果变量是可以null，编译器强制我们去用某种方式处理。
     * 指定一个变量是可null是通过在类型的最后增加一个问号?，因为在Kotlin中一切都是对象（甚至是java中
     * 原始数据类型），一切都是可null的，所以，当然我们可以有一个可null的integer:val a: Int? = null;
     */
    fun test(): Boolean {
        /**
         * 一个可null类型，你在没有进行检查之前你是不能直接使用它。这个代码不能被编译
         */
        val a: Int? = null
        a.toString()

        /**
         * 前一行代码标记为可null，然后编译器就会知道它，所以在你null检查之前你不能使用它。
         * 还有一个特性是当我们检查一个对象的可null性，之后这个对象就会自动转型成不可null类型，
         * 这就是Kotlin编译器的智能转换
         *
         * 在if中，aa从Int?变成了Int，所以我们可以不需要再检查可null性而直接使用它，if代码之外，
         * 当然我们又得检查处理。这仅仅在变量当前不能被改变的时候才有效，因为否则这个value可能被另外
         * 的线程修改，这时前面的检查会返回false，val属性或者本地变量（val or var）
         *
         * 这听起来会让事情变得更多。难道我们不得不去编写大量代码进行可null性的检查？当然不是，首先，
         * 因为大多数时候你不需要使用null。null引用没有我们想象中的有用，当你想弄清楚一个变量是否可以为null
         * 时你就会发现这一点，但是Kotlin也有它自己的使处理更简洁的方案
         *
         * 这里我们使用了安全访问操作符?，只有这个变量不是null的时候才会去执行前面的那行代码，否则，它不会
         * 做任何事情。并且我们甚至使用Elvis operator(?:):
         *
         * 在Kotlin中throw和return都是表达式，他们可以用在Elvis operator操作符的右边
         *
         * 然而，我们可能遇到这种场景，我们确定我们是在用一个非null变量，但是它的类型却是可null的。
         * 我们可以使用!!操作符来强制编译器执行可null类型时跳过限制检查
         */
        val aa: Int? = null
        if (aa != null) {
            aa.toString()
        }

        aa?.toString()

        val aaa1 = aa?.toString() ?: ""
        val aaa2 = aa?.toString() ?: return false
        val aaa3 = aa?.toString() ?: throw IllegalStateException()

        /**
         * 下面的代码将会被编译，但是很显然会奔溃。所以我们要确保只能在特定的情况下使用。
         * 童话村那个我们可以自己选择作为解决方案。如果一份代码满篇都是!!，那就有股代码没有被正确吃力的气味了
         */
        aa!!.toString()

        return false
    }
}