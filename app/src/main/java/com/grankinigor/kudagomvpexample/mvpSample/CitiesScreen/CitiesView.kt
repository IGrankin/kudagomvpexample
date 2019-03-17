package com.grankinigor.kudagomvpexample.mvpSample.CitiesScreen

interface CitiesView {
    interface View {
        fun showCities(citiesArray: ArrayList<CityModel>)
    }

    interface Presenter {
        fun loadCities()
        fun onDestroy()
    }

    interface Repository {
        fun loadCities(): ArrayList<CityModel>
    }
}