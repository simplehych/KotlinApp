package com.simple.kotlinapp

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteCursorDriver
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQuery

/**
 * Created by hych on 2017/6/1 13:34
 */
open class ManagedSqLiteOpenHelper(context: Context?,
                              name: String?,
                              factory: ((db: SQLiteDatabase,
                                         masterQuery: SQLiteCursorDriver,
                                         editTable: String,
                                         query: SQLiteQuery) -> Cursor)?,
                              version: Int)
    : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
//        db.createTable(CityForecastTable.NAME, true,
//                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
//                CityForecastTable.CITY to TEXT,
//                CityForecastTable.COUNTRY to TEXT)
//
//        db.createTable(DayForecastTable.NAME, true,
//                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
//                DayForecastTable.DATE to INTEGER,
//                DayForecastTable.DESCRIPTION to TEXT,
//                DayForecastTable.HIGH to INTEGER,
//                DayForecastTable.LOW to INTEGER,
//                DayForecastTable.ICON_URL to TEXT,
//                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        db.dropTable(CityForecastTable.NAME, true)
//        db.dropTable(DayForecastTable.NAME, true)
//        onCreate(db)
    }

    public fun <T> use(f: SQLiteDatabase.() -> T): T {
        try {
            return openDatabase().f()
        } finally {
            closeDatabase()
        }
    }

    private fun closeDatabase() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun openDatabase(): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

private fun <T> Any.f(): T {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
