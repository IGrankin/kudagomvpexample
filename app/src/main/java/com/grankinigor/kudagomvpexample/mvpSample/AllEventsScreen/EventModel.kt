package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen

class EventModel {
    var imageURL: String
    var headerText: String
    var description: String
    var date: String?
    var place: String?
    var price: String?
    var id: String

    constructor(imageURL: String, headerText: String, description: String, date: String?, place: String?, price: String?, id: String) {
        this.imageURL = imageURL
        this.headerText = headerText
        this.description = description
        this.date = date
        this.place = place
        this.price = price
        this.id = id
    }


}