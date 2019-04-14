package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen

import java.io.Serializable

class EventModel: Serializable {
    var imageURL: ArrayList<String>
    var headerText: String
    var description: String
    var body_text: String
    var date: String?
    var place: String?
    var price: String?
    var id: String

    constructor(imageURL: ArrayList<String>, headerText: String, description: String, body_text:String, date: String?, place: String?, price: String?, id: String) {
        this.imageURL = imageURL
        this.headerText = headerText
        this.description = description
        this.body_text = body_text
        this.date = date
        this.place = place
        this.price = price
        this.id = id
    }


}