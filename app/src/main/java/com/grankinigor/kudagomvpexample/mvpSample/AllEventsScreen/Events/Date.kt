package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen.Events

data class Date(
    val end: Int,
    val end_date: String,
    val end_time: Any,
    val is_continuous: Boolean,
    val is_endless: Boolean,
    val is_startless: Boolean,
    val schedules: List<Any>,
    val start: Int,
    val start_date: String,
    val start_time: String,
    val use_place_schedule: Boolean
)