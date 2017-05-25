package com.simple.kotlinapp.domain

/**
 * Created by hych on 2017/5/25 14:26
 */

public interface Command<out T> {
    /**
     * 这个command会执行一个操作并且返回某种类型的对象，这个类型可以通过泛型被指定，你需要知道一个有趣的概念
     *
     * 一切Kotlin函数都会返回一个值，如果没有指定，它就会默认返回一个Unit类，所以如我我们想让Command不返回数据，我们可以指定它的类型为Unit
     * Kotlin中的接口比java中的强大多了，因为他们可以包含代码，但是我们现在不需要更多的代码，以后章节讨论
     *
     */
    fun execute(): T
}
