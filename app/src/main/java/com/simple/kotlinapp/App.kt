package com.simple.kotlinapp

import android.app.Application
import android.database.sqlite.SQLiteOpenHelper
import kotlin.properties.Delegates

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

        /**
         * notNull
         * 有时候我们需要在某些地方初始化化这个属性，但是我们不能在构造函数中确定，或者我们不能在狗仔函数
         * 中做任何事情。第二种情况在Android中很常见：在Activity、Fragment、service、receivers...无论如何，
         * 一个非抽象的属性在构造函数执行完之前需要被赋值，为了给这些属性赋值，我们无法让它一直等待我们希望
         * 给它赋值的时候。我们至少有俩种选择方案。
         *
         * 第一种就是使用可null类型并且赋值为null，直到我们有了真正想赋的值，但是我们就需要在每个地方不断是否是null
         * 都要去检查，如果我们确定这个属性在我们使用的时候都不会是null，这可能会使我们需要编写一些必要的代码了。
         *
         * 第二种选择是使用notNull委托。它会含有一个可null的比那两并会在我们设置这个属性的时候分配一个真实的值。
         * 如果这个值在被获取之前没有被分配，它就会抛出一个异常
         *
         * TODO Java代码也会抛异常吧？没有看出区别或者好处？
         */
        var instance: App by Delegates.notNull()

        //        private var instance: Application? = null
        fun instance() = instance!!
    }

    /**
     * lazy
     * 包含一个lambda，当第一次指定getValue的时候这个lambda会被调用，所以这个属性可以被延迟初始化。
     * 之后的调用都只会返回同一个值，这是非常有趣的特性，当我们在他们第一次真正调用之前不是必须需要它们的时候。
     * 我们可以节省内存，在这些属性真正需要钱不进行初始化
     *
     * 在下面的代码中，database并没有真正初始化，直到第一次调用OnCreate时。在那之后没我们才确保applicationContext存在
     * 并且已经准备好可以被我们使用了，lazy操作符是线程安全的
     *
     * 如果你不担心多线程问题或者向提高更多的性能，你可以使用lazy(LazyThreadSafeMode.NONE)
     */
    val database: SQLiteOpenHelper by lazy {
        TODO()
//        MyDatabaseHelper(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        val db = database.writableDatabase
    }

}


class ViewModel(val db: MyDatabase) {

    /**
     * Observable
     * 这个委托会帮我们检测我们希望观察的属性的变化。当被观察属性的set方法被调用的时候，它就会自动执行
     * 我们指定的lambda表达式，所以一旦该属性被赋了新的值，我们就会接受被委托的属性、旧值和新值
     *
     * 下面的代码展示了，一下我们需要关心的ViewModel，每次值被修改了就会保存它们到数据库
     */
    var myProperty by Delegates.observable("") {
        d, old, new ->
        db.saveChanges(this, new)
        //TODO 关于lambda表达式中三个参数从何而来 d old new 怎么进行区分？
    }

    /**
     * Vetoable
     * 这是一个特殊的observable，它让你决定这个值需要被保存，它可以被用于在正在保存之前进行一些判断
     *
     * 下面的代码展示了 这个委托只允许在新的值时正数的时候执行保存。在lambda中，最后一行表示返回值，你不需要使用return关键字（实质上不能被编译）
     */
    var positiveNumber = Delegates.vetoable(0) {
        d, old, new ->
        new >= 0
    }
}
