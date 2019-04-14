package com.grankinigor.kudagomvpexample.mvpSample.EventScreen

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.grankinigor.kudagomvpexample.R
import com.squareup.picasso.Picasso

class EventPhotosAdapter: PagerAdapter() {

    private var mPhotosList: ArrayList<String> = ArrayList()

    fun setPhotos(photosList: ArrayList<String>) {
        this.mPhotosList = photosList
        notifyDataSetChanged()
    }

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }

    override fun getCount(): Int {
        return mPhotosList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        (container as ViewPager).removeView(view as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = buildImageView(container.context, mPhotosList[position])
        container.addView(view)
        return view
    }

    private fun buildImageView(context: Context, photoURL: String): View {
        val imageView: ImageView = ImageView(context)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        Picasso.get().load(photoURL).into(imageView)
        return imageView
    }

}