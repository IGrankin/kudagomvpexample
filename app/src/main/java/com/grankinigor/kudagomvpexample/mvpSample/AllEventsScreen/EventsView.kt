package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen

import android.content.Context
import com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen.Events.Events
import com.grankinigor.kudagomvpexample.mvpSample.Common.SwipeToRefreshInterface

interface EventsView {
    interface View:SwipeToRefreshInterface {
        fun showLastEvents(eventsList: ArrayList<EventModel>)
    }

    interface Presenter {
        fun loadLastEvents(context: Context, city: String, pageCount: Int)
        fun onDestroy()
    }

    interface Repository {
        fun loadLastEvents(context: Context, city: String, pageCount: Int, onSuccess: (ArrayList<EventModel>) -> Unit, onError: (Throwable) -> Unit)
    }
}