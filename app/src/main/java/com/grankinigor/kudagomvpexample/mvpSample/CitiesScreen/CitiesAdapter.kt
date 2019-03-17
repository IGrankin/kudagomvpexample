package com.grankinigor.kudagomvpexample.mvpSample.CitiesScreen

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.grankinigor.kudagomvpexample.R

class CitiesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private var mCitiesSourceList: ArrayList<CityModel> = ArrayList()
    private var lastChoosed: String = ""

    constructor() {
        mCitiesSourceList.clear()
    }

    fun showCities(cities: ArrayList<CityModel>) {
        mCitiesSourceList.clear()
        mCitiesSourceList.addAll(cities)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val itemView = layoutInflater.inflate(R.layout.city_cell, p0, false)
        return CitiesViewHolder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return mCitiesSourceList.count()
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        if (p0 is CitiesViewHolder) {
            p0.bind(mCitiesSourceList[p1])
        }
    }

    class CitiesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var mName: TextView = itemView.findViewById(R.id.city_cell_txt_name)
        private var mMark: ImageView = itemView.findViewById(R.id.city_cell_txt_marked)

        fun bind(cityModel: CityModel) {
            mName.text = cityModel.name
        }
    }

}