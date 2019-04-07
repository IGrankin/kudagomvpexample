package com.grankinigor.kudagomvpexample.mvpSample.EventScreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.widget.ImageView
import com.grankinigor.kudagomvpexample.R

class EventActivity : AppCompatActivity() {

    private lateinit var mPhotoAdapter: EventPhotosAdapter
    private lateinit var mViewPager: ViewPager
    private lateinit var mPagerIndicator: PagerIndicator
    private lateinit var mCloseButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        mViewPager = findViewById(R.id.event_description_view_pager)
        mPagerIndicator = findViewById(R.id.pager_indicator)

        mPhotoAdapter = EventPhotosAdapter()
        mViewPager.adapter = mPhotoAdapter
        mPagerIndicator.setViewPager(mViewPager)

        mPhotoAdapter.setPhotos(arrayListOf<String>("", "", ""))

        mCloseButton = findViewById(R.id.event_close_button)
        mCloseButton.setOnClickListener {
            finish()
        }
    }
}
