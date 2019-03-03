package com.grankinigor.kudagomvpexample.mvpSample

class SamplePresenter:SampleInterface.Presenter {

    private lateinit var mView: SampleInterface.View
    private lateinit var mRepository: SampleInterface.Repository

    constructor(view: SampleInterface.View) {
        this.mView = view
        this.mRepository = SampleRepository()
    }

    override fun onButtonWasClicked() {
        val message: String = mRepository.loadLastNews()
        mView.showLastNews(message)
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}