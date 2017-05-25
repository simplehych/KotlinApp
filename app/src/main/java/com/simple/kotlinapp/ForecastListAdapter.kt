package com.simple.kotlinapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.simple.kotlinapp.domain.model.Forecast
import com.simple.kotlinapp.domain.model.ForecastList
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by hych on 2017/5/24 09:42
 */
class ForecastListAdapter(val weekForecast: ForecastList,
                          val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(weekForecast[position])
        /**
         * with函数是一个非常有用的函数，它包含在Kotlin的一个标准库中，它接受一个对象和一个扩展函数作为它的参数，
         * 然后使这个对象扩展这个函数，这表示所有我们在括号中编写的代码都是作为对象(第一个参数)的一个扩展函数，
         * 我们可以就想作为this一样使用所有它的public方法和属性。当我们针对同一个对象做很多操作的时候这个非常有利于简化代码
         *
         */
        with(weekForecast[position]) {
            /**
             * Kotlin List是实现了数组操作符的，我们可以像java中的数组一样访问list的每一项
             *  val x = myList[2]
             *  myList[2] = 4
             */
            //            holder?.textView?.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.size()

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {


        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: com.simple.kotlinapp.domain.model.Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"

                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }

    public interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}

