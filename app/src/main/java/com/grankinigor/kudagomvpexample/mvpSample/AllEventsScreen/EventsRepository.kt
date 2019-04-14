package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen

import android.content.Context
import com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen.Events.Events
import com.grankinigor.kudagomvpexample.mvpSample.Network.KudaGoBaseApiRepository

class EventsRepository: EventsView.Repository {

    override fun loadLastEvents(context: Context, city: String, pageCount: Int, onSuccess: (ArrayList<EventModel>) -> Unit, onError: (Throwable) -> Unit) {
        KudaGoBaseApiRepository(context).loadEvents(city, pageCount,
            onSuccess = {
                var events: ArrayList<EventModel> = ArrayList()
                it.results.forEach { eventResult ->
                    var date: String
                    eventResult.dates?.first()?.start_date.let {
                        date = it
                    }
                    var place: String
                    eventResult.place?.address.let {
                        place = it
                    }
                    var price: String
                    eventResult.price.let {
                        price = it
                    }
                    var images: ArrayList<String> = ArrayList()
                    eventResult.images.forEach { imageSource ->
                        images.add(imageSource.image)
                    }
                    var eventModel: EventModel = EventModel(
                        images,
                        eventResult.title,
                        eventResult.description,
                        eventResult.body_text,
                        date,
                        place,
                        price,
                        ""
                    )
                    events.add(eventModel)
                }
                onSuccess(events)
            },
            onError = {
                onError(it)
            })
    }

//    override fun loadLastEvents():ArrayList<EventModel> {
//        val firstEventModel = EventModel("",
//            "Музыкальный фестиваль LiveFest Summer",
//            "Первый фестиваль LiveFest на курорте «Роза Хутор» собрал перспективные музыкальные...",
//            "10-11 августа",
//            "ЦПКиО им. Горького",
//            "1 200 - 1 500 \u20BD",
//            "0")
//        val secondEventModel = EventModel("",
//            "Рестобар «Чеширский кот»",
//            "Из центра Москвы — прямиком в Зазеркалье! В рестобаре вас встретят улыбчивый кот и д...",
//            null,
//            "ул. Кузнецкий Мост, д. 19/1",
//            "2 500 \u20BD",
//            "1")
//        val thirdEventModel = EventModel("",
//            "Ночь музеев в Москве",
//            "В ночь с субботы на воскресенье 19 и 20 мая музеи столицы будут открыты с шести вечер...",
//            "10-11 августа",
//            "Все музеи Москвы",
//            "1 200 - 1 500 \u20BD",
//            "2")
//        val eventsArray = arrayListOf<EventModel>(firstEventModel, secondEventModel,
//            thirdEventModel, firstEventModel, secondEventModel, thirdEventModel,
//            firstEventModel, secondEventModel, thirdEventModel, thirdEventModel,
//            firstEventModel, secondEventModel, thirdEventModel,
//            firstEventModel, secondEventModel, thirdEventModel)
//        return eventsArray
//    }
}