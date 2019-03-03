package com.grankinigor.kudagomvpexample.mvpSample

interface SampleInterface {
    interface View {
        fun showLastNews(string: String)
    }

    interface Presenter {
        fun onButtonWasClicked()
        fun onDestroy()
    }

    interface Repository {
        fun loadLastNews():String
    }
}