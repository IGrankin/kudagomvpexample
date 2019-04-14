package com.grankinigor.kudagomvpexample.mvpSample.CitiesScreen

import android.content.Context

class CitiesPresenter: CitiesView.Presenter {

    private lateinit var mView: CitiesView.View
    private lateinit var mRepository: CitiesView.Repository

    constructor(view: CitiesView.View) {
        this.mView = view
        this.mRepository = CitiesRepository()
    }

    override fun loadCities(context: Context) {
        mView.startLoading()
        mRepository.loadCities(context, onSuccess = {
            mView.showCities(it)
            mView.endLoading()
        }, onError = {
            mView.endLoading()
        })

    }

    override fun onDestroy() {
    }
}