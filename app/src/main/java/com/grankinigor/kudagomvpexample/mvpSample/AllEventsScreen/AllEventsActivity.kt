package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import com.grankinigor.kudagomvpexample.R
import com.grankinigor.kudagomvpexample.mvpSample.CitiesScreen.ChooseCityActivity

import kotlinx.android.synthetic.main.activity_all_events.*

class AllEventsActivity : AppCompatActivity(), EventsView.View {

    private lateinit var mRvEvents: RecyclerView
    private lateinit var mRvAdapter: EventsAdapter
    lateinit var mPresenter: EventsPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_events)
        setSupportActionBar(toolbar)

        mPresenter = EventsPresenter(this)
        mRvAdapter = EventsAdapter()

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setTitle("")
        val mChooseCityBtn: TextView = findViewById(R.id.choose_city_btn)
        mChooseCityBtn.setOnClickListener {
            startActivity(Intent(this, ChooseCityActivity::class.java))
        }
        mRvEvents = findViewById(R.id.table_events)

        mRvEvents.adapter = mRvAdapter
        mRvEvents.layoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)
        mRvEvents.setHasFixedSize(true)

        mPresenter.loadLastEvents()
    }

    override fun showLastEvents(eventsList: ArrayList<EventModel>) {
        mRvAdapter.showLastEvents(eventsList)
    }
}
