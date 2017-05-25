package com.simple.kotlinapp

import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup

/**
 * Created by hych on 2017/5/25 15:56
 */
//与上列代码无关，暂时放这
operator fun ViewGroup.get(position: Int): View = getChildAt(position)

val View.ctx: Context?
    get() {
        return context
    }

/**
 * 内联函数与普通函数
 * 一个内联函数会在编译的时候被替换掉，而不是真正的方法调用。这在一些情况下可以减少内存分配和运行时开销
 * 举个例子：如果我们有一个函数，只接收一个函数作为它的参数。如果是一个普通的函数，内部会创建一个含有那个函数的对象。
 * 另一方面，内联函数会把我们调用这个函数的地方替换掉，所以它不需要为此生成一个内部对象
 */
inline fun supportsLollipop(code: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        code()
    }
}

class C private constructor(a: Int) {  }