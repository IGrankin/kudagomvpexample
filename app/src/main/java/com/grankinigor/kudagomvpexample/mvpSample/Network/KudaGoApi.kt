package com.grankinigor.kudagomvpexample.mvpSample.Network

object KudaGoApi {
    private const val BASE_URL = "https://kudago.com/public-api"
    private const val API_VERSION = "/v1.4"
    private const val CITIES_URL = "$BASE_URL$API_VERSION/locations"
    private const val EVENTS_URL = "$BASE_URL$API_VERSION/events"

    fun getCitiesURL() = "$CITIES_URL/?lang=&fields=&order_by="
    fun getEventsURL(city: String, pageCount: Int) = "$EVENTS_URL/?location=$city&page=$pageCount&page_size=10&fields=images,title,description,place,dates,price,body_text&expand=place,dates,price,body_text&text_format=text"
}