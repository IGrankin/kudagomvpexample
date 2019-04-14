package com.grankinigor.kudagomvpexample.mvpSample.EventScreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.grankinigor.kudagomvpexample.R
import com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen.EventModel

class EventActivity : AppCompatActivity(), EventView.View {

    private lateinit var mPhotoAdapter: EventPhotosAdapter
    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerIndicator: PagerIndicator
    private lateinit var mCloseButton: ImageView
    private lateinit var mPresenter: EventPresenter

    private lateinit var mTitle: TextView
    private lateinit var mSubtitle: TextView
    private lateinit var mDescription: TextView
    private lateinit var mContentPlace: TextView
    private lateinit var mLinearPlace: LinearLayout
    private lateinit var mContentDate: TextView
    private lateinit var mLinearDate: LinearLayout
    private lateinit var mContentPrice: TextView
    private lateinit var mLinearPrice: LinearLayout
    private lateinit var mDatePlacePriceLinearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        mPresenter = EventPresenter(this)
        mViewPager = findViewById(R.id.event_description_view_pager)
        mViewPager.offscreenPageLimit = 3
        mPagerIndicator = findViewById(R.id.pager_indicator)

        mPhotoAdapter = EventPhotosAdapter()
        mViewPager.adapter = mPhotoAdapter
        mPagerIndicator.setViewPager(mViewPager)

        mCloseButton = findViewById(R.id.event_close_button)
        mCloseButton.setOnClickListener {
            finish()
        }

        mTitle = findViewById(R.id.event_title_txt)
        mSubtitle = findViewById(R.id.event_subtitle_txt)
        mDescription = findViewById(R.id.event_desc_txt)
        mContentPlace = findViewById(R.id.card_content_txt_place)
        mLinearPlace = findViewById(R.id.event_place_linear_layout)
        mContentDate = findViewById(R.id.card_content_txt_date)
        mLinearDate = findViewById(R.id.event_date_linear_layout)
        mContentPrice = findViewById(R.id.card_content_txt_price)
        mLinearPrice = findViewById(R.id.event_price_linear_layout)
        mDatePlacePriceLinearLayout = findViewById(R.id.time_and_date_linear_layout)


        val eventModelFromIntent = intent.getSerializableExtra("eventModel")
        mPresenter.showEvent(eventModelFromIntent as EventModel)
    }

    override fun showEvent(eventModel: EventModel) {
        mTitle.text = eventModel.headerText
        mSubtitle.text = eventModel.description
        mDescription.text = eventModel.body_text
        mPhotoAdapter.setPhotos(eventModel.imageURL)


        if (eventModel.place != null) {
            mContentPlace.text = eventModel.place
        } else {
            mDatePlacePriceLinearLayout.removeView(mLinearPlace)
        }
        if (eventModel.date != null) {
            mContentDate.text = eventModel.date
        } else {
            mDatePlacePriceLinearLayout.removeView(mLinearDate)
        }
        if (eventModel.price != null && eventModel.price!!.count() > 0) {
            mContentPrice.text = eventModel.price
        } else {
            mDatePlacePriceLinearLayout.removeView(mLinearPrice)
        }

    }
}
