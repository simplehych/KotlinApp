package com.simple.kotlinapp.practice

/**
 * Created by hych on 2017/6/1 14:45
 */
class `06Operator` {

    fun operator() {


        val list = listOf(1, 2, 3, 4, 5, 6)

        /**
         * any
         * 至少有一个元素符合给出的判断，则返回true
         */
        assert(list.any { it % 2 == 0 })

        /**
         * all
         * 全部的元素符合给出的判断条件，则返回true
         */
        assert(list.all { it < 10 })

        /**
         * count
         * 返回符合给出判断条件的元素总数
         */
        list.count { it % 2 == 0 }

        /**
         * fold
         * 在一个初始值的基础上从第一项到最后一项通过一个函数累计所有的元素
         */
        list.fold(4) { total, next -> total + next }

        /**
         * foldRight
         * 与fold一样，但是顺序是从最后一项到第一项
         */
        list.foldRight(4) { total, next -> total + next }

        /**
         * reduce
         * 与fold一样，但是没有一个初始值，通过一个函数从第一项到最后一项进行累计
         */
        list.reduce { total, next -> total + next }

        /**
         * reduceRight
         * 与reduce一样，但是顺序是从最后一项到第一项
         */
        list.reduceRight { total, next -> total + next }

        /**
         * forEach
         * 遍历所有元素，并执行给定的操作
         */
        list.forEach { println(it) }

        /**
         * forEachIndexed
         * 与forEach相同，但是我们可以同时得到元素的index
         */
        list.forEachIndexed { index, value -> println("position $index contains a $value") }

        /**
         * max
         * 返回最大的一项，如果没有则返回null
         */
        list.max()

        /**
         * maxBy
         * 根据给定的函数返回最大的一项，如果没有则返回null
         */
        list.maxBy { -it }

        /**
         * min
         * 返回最小的一项，如果没有则返回null
         */
        list.min()

        /**
         * minBy
         * 根据给定的函数返回最小的一项，如果没有则返回null
         */
        list.minBy { -it }

        /**
         * none
         * 如果没有任何元素与给定的函数匹配，则返回true
         */
        list.none { it % 7 == 0 }

        /**
         * sumBy
         * 返回所有每一项通过函数转换之后的数据的总和
         */
        list.sumBy { it % 2 }
    }


}