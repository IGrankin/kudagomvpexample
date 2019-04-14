package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen.Events

data class Events(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)