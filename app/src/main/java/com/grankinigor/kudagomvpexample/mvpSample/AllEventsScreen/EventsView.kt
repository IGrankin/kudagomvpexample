package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen

interface EventsView {
    interface View {
        fun showLastEvents(eventsList: ArrayList<EventModel>)
    }

    interface Presenter {
        fun loadLastEvents()
        fun onDestroy()
    }

    interface Repository {
        fun loadLastEvents():ArrayList<EventModel>
    }
}