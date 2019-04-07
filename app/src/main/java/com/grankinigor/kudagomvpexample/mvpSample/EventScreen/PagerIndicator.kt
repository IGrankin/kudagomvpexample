package com.grankinigor.kudagomvpexample.mvpSample.EventScreen

import android.content.Context
import android.database.DataSetObserver
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import java.lang.IllegalStateException
import android.view.ViewGroup
import android.view.View
import com.grankinigor.kudagomvpexample.R


class PagerIndicator @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
): LinearLayout(context, attributeSet, defStyleAttr), ViewPager.OnAdapterChangeListener,
    ViewPager.OnPageChangeListener {

    private val indicatorSize = context.resources.getDimensionPixelSize(R.dimen.indicator_size)
    private val indicatorMargin = context.resources.getDimensionPixelSize(R.dimen.indicator_margin)
    private var viewPager: ViewPager? = null
    private var dataSetObserver: DataSetObserver? = null


    init {
        gravity = Gravity.CENTER
    }

    fun setViewPager(viewPager: ViewPager) {
        this.viewPager = viewPager
        this.viewPager?.addOnAdapterChangeListener(this)
        this.viewPager?.addOnPageChangeListener(this)
        unRegisterObserver()
        registerObserver()
        inflateIndicators()
    }


    private fun inflateIndicators() {
        removeAllViews()
        val layoutParams = LinearLayout.LayoutParams(indicatorSize, indicatorSize)
        layoutParams.marginStart = indicatorMargin / 2
        layoutParams.marginEnd = indicatorMargin / 2
        val pageCount = viewPager?.adapter?.count ?: 0
        (0 until pageCount).forEach { _ ->
            val indicatorView = IndicatorView(context)
            indicatorView.layoutParams = layoutParams
            addView(indicatorView)
        }
        viewPager?.let {
            onPageSelected(it.currentItem)
        }
    }

    //MARK: - observer methods

    private fun registerObserver() {
        if (dataSetObserver != null) {
            return
        }

        dataSetObserver = object : DataSetObserver() {
            override fun onChanged() {
                inflateIndicators()
            }
        }

        try {
            viewPager?.adapter?.registerDataSetObserver(dataSetObserver as DataSetObserver)
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

    private fun unRegisterObserver() {
        if (dataSetObserver == null || viewPager == null || viewPager?.adapter == null) {
            return
        }

        try {
            viewPager?.adapter?.unregisterDataSetObserver(dataSetObserver as DataSetObserver)
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
    }

    //MARK: - Interface implementations

    override fun onAdapterChanged(p0: ViewPager, p1: PagerAdapter?, p2: PagerAdapter?) {
        unRegisterObserver()
        registerObserver()
        inflateIndicators()
    }

    override fun onPageSelected(p0: Int) {
        getAllChildren(this)
            .map { it as IndicatorView }
            .forEachIndexed { index, indicator -> indicator.selectIndicator = index == p0}
    }

    private fun getAllChildren(v: View): ArrayList<View> {
        val result = ArrayList<View>()
        val vg = v as ViewGroup
        for (i in 0 until vg.childCount) {
            val child = vg.getChildAt(i)
            result.add(child)
        }
        return result
    }

    override fun onPageScrollStateChanged(p0: Int) {

    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

    }

}