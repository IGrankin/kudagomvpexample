package com.grankinigor.kudagomvpexample.mvpSample.EventScreen

import com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen.EventModel

interface EventView {
    interface View {
        fun showEvent(eventModel: EventModel)
    }

    interface Presenter {
        fun showEvent(eventModel: EventModel)
    }
}