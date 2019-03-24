package com.grankinigor.kudagomvpexample.mvpSample.EventScreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.widget.ImageView
import com.grankinigor.kudagomvpexample.R

class EventActivity : AppCompatActivity() {

    private lateinit var mPhotoAdapter: EventPhotosAdapter
    private lateinit var mViewPager: ViewPager
    private lateinit var mPhotosEventTabLayout: TabLayout
    private lateinit var mCloseButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        mViewPager = findViewById(R.id.event_description_view_pager)
        mPhotoAdapter = EventPhotosAdapter()
        mPhotoAdapter.setPhotos(arrayListOf<String>("", "", ""))
        mViewPager.adapter = mPhotoAdapter

        mPhotosEventTabLayout = findViewById(R.id.event_photo_tab_layout)
        mPhotosEventTabLayout.setupWithViewPager(mViewPager, true)

        mCloseButton = findViewById(R.id.event_close_button)
        mCloseButton.setOnClickListener {
            finish()
        }
    }
}
