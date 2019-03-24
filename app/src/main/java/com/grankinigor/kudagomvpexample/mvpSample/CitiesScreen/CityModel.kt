package com.grankinigor.kudagomvpexample.mvpSample.CitiesScreen

import java.io.Serializable

class CityModel:Serializable {
    var slug: String
    var name: String

    constructor(slug: String, name: String) {
        this.slug = slug
        this.name = name
    }
}