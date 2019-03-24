package com.grankinigor.kudagomvpexample.mvpSample.CitiesScreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.grankinigor.kudagomvpexample.R

import kotlinx.android.synthetic.main.activity_choose_city.*

class ChooseCityActivity : AppCompatActivity(), CitiesView.View, CitiesAdapter.OnCitiesClick {

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
        mRvAdapter = CitiesAdapter(this)
        val cityModelFromIntent = intent.getSerializableExtra("city")
        mRvAdapter.setNewSelectedCity(cityModelFromIntent as CityModel)

        mRvCities = findViewById(R.id.table_cities)
        mRvCities.adapter = mRvAdapter
        mRvCities.layoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL, false)
        mRvCities.setHasFixedSize(true)

        mPresenter.loadCities()
        mCloseButton = findViewById(R.id.cities_btn_close)
        mCloseButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("city", mRvAdapter.lastChoosedCityModel)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }


    override fun showCities(citiesArray: ArrayList<CityModel>) {
        mRvAdapter.showCities(citiesArray)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 1) {
//            if (resultCode == Activity.RESULT_OK) {
//                mRvAdapter.setNewSelectedCity(data!!.getSerializableExtra("name") as CityModel)
//            }
//        }
//    }

    //OnClickListener


    override fun onCityClicked(itemView: View, cityModel: CityModel) {
        val mark = itemView.findViewById<ImageView>(R.id.city_cell_txt_marked)
        mRvAdapter.setNewSelectedCity(cityModel)
    }

    override fun markViewAsAdded(itemView: View) {
        val mark = itemView.findViewById<ImageView>(R.id.city_cell_txt_marked)
        mark.visibility = View.VISIBLE
    }

    override fun markViewAsRegular(itemView: View) {
        val mark = itemView.findViewById<ImageView>(R.id.city_cell_txt_marked)
        mark.visibility = View.INVISIBLE
    }
}
