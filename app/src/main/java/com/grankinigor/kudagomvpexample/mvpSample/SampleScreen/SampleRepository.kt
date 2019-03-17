package com.grankinigor.kudagomvpexample.mvpSample.SampleScreen

class SampleRepository: SampleInterface.Repository {
    override fun loadLastNews(): String {
        return "Hello to mvp from repository"
    }
}