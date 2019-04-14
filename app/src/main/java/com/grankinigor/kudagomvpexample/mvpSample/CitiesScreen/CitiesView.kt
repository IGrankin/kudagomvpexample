package com.grankinigor.kudagomvpexample.mvpSample.CitiesScreen

import android.content.Context
import com.grankinigor.kudagomvpexample.mvpSample.Common.SwipeToRefreshInterface

interface CitiesView {
    interface View: SwipeToRefreshInterface {
        fun showCities(citiesArray: ArrayList<CityModel>)
    }

    interface Presenter {
        fun loadCities(context: Context)
        fun onDestroy()
    }

    interface Repository {
        fun loadCities(context: Context, onSuccess: (CitiesResponse) -> Unit, onError: (Throwable) -> Unit)
    }
}