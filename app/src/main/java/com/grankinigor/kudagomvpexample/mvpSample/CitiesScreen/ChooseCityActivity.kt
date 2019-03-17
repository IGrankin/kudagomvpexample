package com.grankinigor.kudagomvpexample.mvpSample.CitiesScreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.grankinigor.kudagomvpexample.R

import kotlinx.android.synthetic.main.activity_choose_city.*

class ChooseCityActivity : AppCompatActivity(), CitiesView.View {

    private lateinit var mRvCities: RecyclerView
    private lateinit var mRvAdapter: CitiesAdapter
    lateinit var mPresenter: CitiesPresenter
    private lateinit var mCloseButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_city)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setTitle("")

        mPresenter = CitiesPresenter(this)
        mRvAdapter = CitiesAdapter()

        mRvCities = findViewById(R.id.table_cities)
        mRvCities.adapter = mRvAdapter
        mRvCities.layoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)
        mRvCities.setHasFixedSize(true)

        mPresenter.loadCities()
        mCloseButton = findViewById(R.id.cities_btn_close)
        mCloseButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("city", "Воронеж")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }


    override fun showCities(citiesArray: ArrayList<CityModel>) {
        mRvAdapter.showCities(citiesArray)
    }

}
