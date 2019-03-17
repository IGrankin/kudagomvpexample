package com.grankinigor.kudagomvpexample.mvpSample.CitiesScreen

class CitiesRepository: CitiesView.Repository {
    override fun loadCities(): ArrayList<CityModel> {
        val firstCity = CityModel("vrn", "Воронеж")
        val secondCity = CityModel("msc", "Москва")
        val thirdCity = CityModel("szrn", "Сызрань")
        val citiesArray = arrayListOf<CityModel>(firstCity, secondCity, thirdCity)
        return citiesArray
    }
}