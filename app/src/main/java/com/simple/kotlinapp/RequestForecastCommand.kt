package com.simple.kotlinapp

import com.simple.kotlinapp.domain.Command
import com.simple.kotlinapp.domain.model.ForecastList

/**
 * Created by hych on 2017/5/25 14:49
 */
class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}