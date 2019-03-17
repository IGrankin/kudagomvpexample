package com.grankinigor.kudagomvpexample.mvpSample.CitiesScreen

class CitiesPresenter: CitiesView.Presenter {

    private lateinit var mView: CitiesView.View
    private lateinit var mRepository: CitiesView.Repository

    constructor(view: CitiesView.View) {
        this.mView = view
        this.mRepository = CitiesRepository()
    }

    override fun loadCities() {
        val citiesArrayList: ArrayList<CityModel> = mRepository.loadCities()
        mView.showCities(citiesArrayList)
    }

    override fun onDestroy() {
    }
}