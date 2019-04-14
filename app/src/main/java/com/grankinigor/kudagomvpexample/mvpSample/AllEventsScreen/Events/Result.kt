package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen.Events

data class Result(
    val body_text: String,
    val dates: List<Date>,
    val description: String,
    val images: List<Image>,
    val place: Place,
    val price: String,
    val title: String
)