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

class DbDataMapper {
    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
//        ForecastList(_id, city, country, daily)
    }

    private fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
//        Forecast(date, description, high, low, iconUrl)
    }
}

//class ForecastDb(
//        val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
//        val dataMapper: DbDataMapper = DbDataMapper()) {
//
//    fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {
//
//        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND " +
//                "${DayForecastTable.DATE} >= ?"
//        val dailyForecast = select(DayForecastTable.NAME)
//                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
//                .parseList { DayForecast(HashMap(it)) }
//
//        val city = select(CityForecastTable.NAME)
//                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
//                .parseOpt { CityForecast(HashMap(it), dailyForecast) }
//
//        if (city != null) dataMapper.convertToDomain(city) else null
//    }
//    fun <T : Any> SelectQueryBuilder.parseList(
//            parser: (Map<String, Any>) -> T): List<T> =
//            parseList(object : MapRowParser<T> {
//                override fun parseRow(columns: Map<String, Any>): T = parser(columns)
//            })
//}
