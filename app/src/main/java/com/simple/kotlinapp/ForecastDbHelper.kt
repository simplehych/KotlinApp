package com.simple.kotlinapp

/**
 * Created by hych on 2017/6/1 13:22
 */
class ForecastDbHelper()
    : ManagedSqLiteOpenHelper(App.instance,
        ForecastDbHelper.DB_NAME,
        null,
        ForecastDbHelper.DB_VERSION) {

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance: ForecastDbHelper by lazy { ForecastDbHelper() }
    }


//    fun SqlType.plus(m: SqlTypeModifier): SqlType {
//        return SqlTypeImpl(name, if (modifier == null) m.toString()
//        else "$modifier $m")
//    }

    val object1: Any = 0
    val object2: Any = 0
    val pair = object1 to object2
}
