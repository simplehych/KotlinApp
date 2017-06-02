package com.simple.kotlinapp.practice

/**
 * Created by hych on 2017/6/1 14:45
 */
class `06Operator` {

    /**
     * 总数操作符
     */
    fun operator1() {

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

    /**
     * 过滤操作符
     */
    fun operator2() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        /**
         * drop
         * 返回包含去掉前n个元素的所有元素的列表
         */
        list.drop(4)

        /**
         * dropWhile
         * 返回根据给定函数从第一项开始去掉指定元素的列表
         */
        list.dropLastWhile { it < 3 }

        /**
         * dropLastWhile
         * 返回根据给定函数从最后一项开始去掉指定元素的列表
         */
        list.dropLastWhile { it > 4 }

        /**
         * filter
         * 过滤所有给定函数条件的元素
         */
        list.filter { it % 2 == 0 }

        /**
         * filterNot
         * 过滤所有不符合给定函数条件的元素
         */
        list.filterNot { it % 2 == 0 }

        /**
         * filterNotNull
         * 过滤所有元素中不是null的元素
         */
        list.filterNotNull()

        /**
         * slice
         * 过滤一个list中指定index的元素
         */
        list.slice(listOf(1, 2))

        /**
         * take
         * 返回从第一个开始的n个元素
         */
        list.take(2)

        /**
         * takeLast
         * 返回从最后一个开始的n个元素
         */
        list.takeLast(2)

        /**
         * takeLastWhile
         * 返回从第一个开始符合给定函数条件的元素
         */
        list.takeLastWhile { it < 3 }
    }

    /**
     * 映射操作符
     */
    fun operator3() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        /**
         * flatMap
         * 遍历所有的元素，为每一个创建一个集合，最后把所有的集合放在一个集合中
         *
         */
        listOf(1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7)
        list.flatMap { listOf(it, it + 1) }

        /**
         * groupBy
         * 返回一个根据给定函数分组后的map
         */
        mapOf("odd" to listOf(1, 3),
                "even" to listOf(2, 4))
        list.groupBy { if (it % 2 == 0) "even" else "odd" }

        /**
         * map
         * 返回一个每一个元素根据给定的函数转换所组成的List
         */
        listOf(2, 4, 6, 8, 10, 12)
        list.map { it * 2 }

        /**
         * mapIndexed
         * 返回一个每一个元素根据给定的包含元素index的函数转换所组成的List
         */
        listOf(0, 2, 6, 12, 20, 30)
        list.mapIndexed { index, it -> index * it }

        /**
         * mapNotNull
         * 返回一个每一个非null元素根据给定的函数转换所组成的List
         */
        listOf(2, 4, 6, 8)
        list.mapNotNull { it * 2 }
    }

    /**
     * 元素操作符
     */
    fun operator4() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        /**
         * contains
         * 集合中是否包含指定元素，有则返回true
         */
        list.contains(2)

        /**
         * elementAt
         * 返回给定index对应的元素，如果index数组越界则会抛出IndexOutBoundsException
         */
        list.elementAt(1)

        /**
         * elementAtOrElse
         * 返回给定index对应的元素，如果index数组越界则会根据给定函数返回默认值
         */
        list.elementAtOrElse(10, { 2 * it })

        /**
         * elementAtOrNull
         * 返回给定index对应的元素，如果index数组越界则会返回null
         */
        list.elementAtOrNull(10)

        /**
         * first
         * 返回符合给定函数条件的第一个元素
         */
        list.first { it % 2 == 0 }

        /**
         * firstOrNull
         * 返回符合给定函数条件的第一个元素，如果没有符合则返回null
         */
        list.firstOrNull { it % 7 == 0 }

        /**
         * indexOf
         * 返回指定元素的第一个index，如果不存在，则返回-1
         */
        list.indexOf(4)

        /**
         * indexOfFirst
         * 返回第一个符合给定函数条件的元素的index，如果没有符合则返回-1
         */
        list.indexOfFirst { it % 2 == 0 }

        /**
         * indexOfLast
         * 返回最后一个符合给定函数条件的元素的index，如果没有符合则返回-1
         */
        list.indexOfLast { it % 2 == 0 }

        /**
         * last
         * 返回符合给定函数条件的最后一个元素
         */
        list.last { it % 2 == 0 }

        /**
         * lastIndexOf
         * 返回指定元素的最后一个index，如果不存在，则返回-1
         */
        list.lastIndexOf(2)

        /**
         * lastOrNull
         * 返回符合给定函数条件的最后一个元素，如果没有符合则返回null
         */
        list.lastOrNull { it % 7 == 0 }

        /**
         * single
         * 返回符合给定函数的单个元素，如果没有挥着超过一个，则抛出异常
         */
        list.single { it % 5 == 0 }

        /**
         * singleOrNull
         * 返回符合给定函数的单个元素，如果没有符合或者超过一个，则返回null
         */
        list.singleOrNull { it % 7 == 0 }
    }

    /**
     * 生产操作符
     */
    fun operator5() {
        val list = listOf(1, 2, 3, 4, 5, 6)

        /**
         * merge  未找到
         * 把两个集合合并成一个新的，相同index的元素通过给定的函数进行合并成新的元素作为新的集合的一个元素，
         * 返回这个新的集合。新的集合的大小由最小的那个集合大小决定。
         * listOf(3, 4, 6, 8, 10, 11)
         * list.merge(listRepeated) { it1, it2 -> it1 + it2 }
         */
        val listRepeated = listOf(2, 2, 3, 4, 5, 5, 6)

        /**
         * partition
         * 把一个给定的集合分割成两个，第一个集合是由原集合每一项元素匹配给定函数条件返回true的元素组成，
         * 第二个集合是由原集合每一项元素匹配给定函数条件返回false的元素组成
         */
        Pair(listOf(2, 4, 6), listOf(1, 3, 5))
        list.partition { it % 2 == 0 }

        /**
         * plus
         * 返回一个包含原集合和给定集合中多有元素的集合，因为函数名字的原因，我们可以使用‘+’操作符
         */
        list.plus(listOf(7, 8))
        list + listOf(7, 8)

        /**
         * zip
         * 返回由Pair组成的List，每个Pair由俩个集合中相同index的元素组成。这个返回的List的大小由最小的那个集合决定
         */
        listOf(Pair(1, 7), Pair(2, 8))
        list.zip(listOf(7, 8))

        /**
         * unzip
         * 从包含pair的list中生成包含list的Pair
         */
        Pair(listOf(5, 6), listOf(7, 8))
        listOf(Pair(5, 7), Pair(6, 8)).unzip()
    }

    /**
     * 顺序操作符
     */
    fun operator6() {
        val unsortedList = listOf(3, 2, 7, 5)

        /**
         * reversed
         * 返回一个与指定list相反顺序的list
         */
        listOf(5, 7, 2, 3)
        unsortedList.reversed()

        /**
         * sorted
         * 返回一个自然排序后的list
         */
        listOf(2, 3, 5, 7)
        unsortedList.sorted()

        /**
         * sortBy
         * 返回一个根据指定函数排序后的list
         */
        listOf(3, 7, 2, 5)
        unsortedList.sortedBy { it % 3 }

        /**
         * sortDescending
         * 返回一个降序排序后的List
         */
        listOf(7, 5, 3, 2)
        unsortedList.sortedDescending()

        /**
         * sortedByDescending
         * 返回一个根据指定函数将序排列后的list
         */
        listOf(2, 5, 7, 3)
        unsortedList.sortedByDescending { it % 3 }
    }
}