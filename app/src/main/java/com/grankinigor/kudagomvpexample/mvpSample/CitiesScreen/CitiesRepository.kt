package com.grankinigor.kudagomvpexample.mvpSample.CitiesScreen

import android.content.Context
import android.util.Log
import com.grankinigor.kudagomvpexample.mvpSample.Network.KudaGoBaseApiRepository

class CitiesRepository: CitiesView.Repository {

//    override fun loadCities(): ArrayList<CityModel> {
//        val firstCity = CityModel("vrn", "Воронеж")
//        val secondCity = CityModel("msc", "Москва")
//        val thirdCity = CityModel("szrn", "Сызрань")
//        val citiesArray = arrayListOf<CityModel>(firstCity, secondCity, thirdCity)
//        return citiesArray
//    }

    override fun loadCities(context: Context, onSuccess: (CitiesResponse) -> Unit, onError: (Throwable) -> Unit) {
            KudaGoBaseApiRepository(context).loadCities(onSuccess = {
            onSuccess(it)
        }, onError = {
            onError(it)
        })
    }
}