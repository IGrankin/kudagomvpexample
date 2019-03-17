package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen

class EventsRepository: EventsView.Repository {
    override fun loadLastEvents():ArrayList<EventModel> {
        val firstEventModel = EventModel("",
            "Музыкальный фестиваль LiveFest Summer",
            "Первый фестиваль LiveFest на курорте «Роза Хутор» собрал перспективные музыкальные...",
            "10-11 августа",
            "ЦПКиО им. Горького",
            "1 200 - 1 500 \u20BD",
            "0")
        val secondEventModel = EventModel("",
            "Рестобар «Чеширский кот»",
            "Из центра Москвы — прямиком в Зазеркалье! В рестобаре вас встретят улыбчивый кот и д...",
            null,
            "ул. Кузнецкий Мост, д. 19/1",
            "2 500 \u20BD",
            "1")
        val thirdEventModel = EventModel("",
            "Ночь музеев в Москве",
            "В ночь с субботы на воскресенье 19 и 20 мая музеи столицы будут открыты с шести вечер...",
            "10-11 августа",
            "Все музеи Москвы",
            "1 200 - 1 500 \u20BD",
            "2")
        val eventsArray = arrayListOf<EventModel>(firstEventModel, secondEventModel,
            thirdEventModel, firstEventModel, secondEventModel, thirdEventModel,
            firstEventModel, secondEventModel, thirdEventModel, thirdEventModel,
            firstEventModel, secondEventModel, thirdEventModel,
            firstEventModel, secondEventModel, thirdEventModel)
        return eventsArray
    }
}