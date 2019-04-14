package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.grankinigor.kudagomvpexample.R
import com.squareup.picasso.Picasso

class EventsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private var mEventsSourceList: ArrayList<EventModel> = ArrayList()
    private var mListener: OnEventClick? = null

    constructor(listener: OnEventClick) {
        mEventsSourceList.clear()
        mListener = listener
    }

    fun showLastEvents(events: ArrayList<EventModel>) {
        mEventsSourceList.clear()
        mEventsSourceList.addAll(events)
        notifyDataSetChanged()
    }

    //MARK: - ViewHolder

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        when (p1) {
            0 -> {
                val layoutInflater = LayoutInflater.from(p0.context)
                val itemView = layoutInflater.inflate(R.layout.events_header, p0, false)
                return EventsHeaderViewHolder(itemView = itemView)
            }
            else -> {
                val layoutInflater = LayoutInflater.from(p0.context)
                val itemView = layoutInflater.inflate(R.layout.cardview_event, p0, false)
                return EventsViewHolder(itemView = itemView)
            }
        }
    }

    override fun getItemCount(): Int {
        return mEventsSourceList.count()
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        if (p0 is EventsViewHolder) {
            p0.bind(eventModel = mEventsSourceList[p1 - 1])
            p0.itemView.setOnClickListener {
                mListener?.let { listener ->
                    listener.onEventClicked(mEventsSourceList[p1 - 1])
                }
            }
        } else if (p0 is EventsHeaderViewHolder) {
            p0.bind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            0
        } else {
            1
        }
    }

    class EventsHeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind() {

        }
    }

    interface OnEventClick {
        fun onEventClicked(eventModel: EventModel)
    }

    class EventsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var mHeaderImage: ImageView = itemView.findViewById(R.id.card_image_header)
        private var mHeaderText: TextView = itemView.findViewById(R.id.card_txt_header)
        private var mDescription: TextView = itemView.findViewById(R.id.card_txt_description)
        private var mContentPlace: TextView = itemView.findViewById(R.id.card_content_txt_place)
        private var mLinearPlace: LinearLayout = itemView.findViewById(R.id.event_place_linear_layout)
        private var mContentDate: TextView = itemView.findViewById(R.id.card_content_txt_date)
        private var mLinearDate: LinearLayout = itemView.findViewById(R.id.event_date_linear_layout)
        private var mContentPrice: TextView = itemView.findViewById(R.id.card_content_txt_price)
        private var mLinearPrice: LinearLayout = itemView.findViewById(R.id.event_price_linear_layout)
        private var mDatePlacePriceLinearLayout: LinearLayout = itemView.findViewById(R.id.time_and_date_linear_layout)

        fun bind(eventModel: EventModel) {
            Picasso.get().
                load(eventModel.imageURL.first()).
                into(mHeaderImage)
            mHeaderText.text = eventModel.headerText
            mDescription.text = eventModel.description

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

}