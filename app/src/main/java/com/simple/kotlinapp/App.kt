package com.simple.kotlinapp

import android.app.Application

/**
 * Created by hych on 2017/5/26 10:42
 *
 * Android有一个问题，就是我们不能去控制很多类的构造函数。比如，我们不能初始化一个非null属性，
 * 因为它的值需要在构造函数中去定义，所以我们需要一个可null的变量，和一个返回非null值的函数，我们知道
 * 我们一直都有一个App的实例，但是在它调用onCreate之前我们不能去操作任何s事情，所以我们为了安全性，
 * 我们假设instance()函数将会总是返回一个非null的app实例
 * 但是这个方案看起来有点不自然，我们需要定义一个属性，然后通过一个函数返回那个属性，我们有其他方法
 * 去达到类似的效果吗，是的，我们可以通过委托这个属性的值给另一类，这个就是我们知道的委托属性
 *
 *
 */
class App : Application() {
    companion object {
        private var instance: Application? = null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}