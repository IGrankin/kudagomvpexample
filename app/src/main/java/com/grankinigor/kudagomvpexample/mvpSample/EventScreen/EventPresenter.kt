package com.grankinigor.kudagomvpexample.mvpSample.EventScreen

import android.content.Context
import android.view.View
import com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen.EventModel

class EventPresenter: EventView.Presenter {
    private lateinit var mView: EventView.View

    constructor(view: EventView.View) {
        this.mView = view
    }

    override fun showEvent(eventModel: EventModel) {
        mView.showEvent(eventModel)
    }


    fun onDestroy() {

    }
}