package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.widget.TextView
import android.widget.Toolbar
import com.grankinigor.kudagomvpexample.R

import kotlinx.android.synthetic.main.activity_all_events.*

class AllEventsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_events)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setTitle("")
        val mChooseCityBtn: TextView = findViewById(R.id.choose_city_btn)
        mChooseCityBtn.setOnClickListener {
            Log.e("all events activity", "choose city button was pressed")
        }
    }

}
