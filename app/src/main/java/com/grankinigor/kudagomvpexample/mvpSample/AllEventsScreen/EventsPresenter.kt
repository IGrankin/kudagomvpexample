package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen

class EventsPresenter {
    private lateinit var mView: EventsView.View
    private lateinit var mRepository: EventsView.Repository

    constructor(view: EventsView.View) {
        this.mView = view
        this.mRepository = EventsRepository()
    }

    fun loadLastEvents() {
        val eventsArrayList: ArrayList<EventModel> = mRepository.loadLastEvents()
        mView.showLastEvents(eventsArrayList)
    }
}