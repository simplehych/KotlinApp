package com.simple.kotlinapp

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

/**
 * Created by hych on 2017/5/22 17:08
 */
class ForecastListAdapter(val items: ArrayList<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent?.context))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.textView?.text = items[position]
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}