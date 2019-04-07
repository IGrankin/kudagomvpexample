package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen

import android.app.Activity
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
import com.grankinigor.kudagomvpexample.mvpSample.CitiesScreen.CityModel
import com.grankinigor.kudagomvpexample.mvpSample.EventScreen.EventActivity

import kotlinx.android.synthetic.main.activity_all_events.*
import org.w3c.dom.Text

class AllEventsActivity : AppCompatActivity(), EventsView.View, EventsAdapter.OnEventClick {

    private lateinit var mRvEvents: RecyclerView
    private lateinit var mRvAdapter: EventsAdapter
    lateinit var mPresenter: EventsPresenter
    private var choosenCity: CityModel = CityModel("msk", "Москва")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_events)
        setSupportActionBar(toolbar)

        mPresenter = EventsPresenter(this)
        mRvAdapter = EventsAdapter(listener = this)

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setTitle("")
        val mChooseCityBtn: TextView = findViewById(R.id.choose_city_btn)
        mChooseCityBtn.setOnClickListener {
            val intent = Intent(this, ChooseCityActivity::class.java)
            intent.putExtra("city", choosenCity)
            startActivityForResult(intent, 1)
        }
        mRvEvents = findViewById(R.id.table_events)

        mRvEvents.adapter = mRvAdapter
        mRvEvents.layoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)
        mRvEvents.setHasFixedSize(true)

        mPresenter.loadLastEvents()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val newCity = data!!.getSerializableExtra("city")
                choosenCity = newCity as CityModel
                val btn:TextView = findViewById(R.id.choose_city_btn)
                btn.text = choosenCity.name
            }
        }
    }

    override fun showLastEvents(eventsList: ArrayList<EventModel>) {
        mRvAdapter.showLastEvents(eventsList)
    }


    override fun onEventClicked() {
        startActivity(Intent(this, EventActivity::class.java))
    }
}
