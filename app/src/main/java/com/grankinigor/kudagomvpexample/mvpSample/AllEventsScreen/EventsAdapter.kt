package com.grankinigor.kudagomvpexample.mvpSample.AllEventsScreen

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.grankinigor.kudagomvpexample.R

class EventsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private var mEventsSourceList: ArrayList<EventModel> = ArrayList()

    constructor() {
        mEventsSourceList.clear()
    }

    fun showLastEvents(events: ArrayList<EventModel>) {
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
            p0.bind(eventModel = mEventsSourceList[p1-1])
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

    class EventsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var mHeaderImage: ImageView = itemView.findViewById(R.id.card_image_header)
        private var mHeaderText: TextView = itemView.findViewById(R.id.card_txt_header)
        private var mDescription: TextView = itemView.findViewById(R.id.card_txt_description)
        private var mContentPlace: TextView = itemView.findViewById(R.id.card_content_txt_place)
        private var mContentDate: TextView = itemView.findViewById(R.id.card_content_txt_date)
        private var mContentPrice: TextView = itemView.findViewById(R.id.card_content_txt_price)

        fun bind(eventModel: EventModel) {
            mHeaderImage.setImageResource(R.drawable.f0df769e2ef1acb5c61a3f8955ba4160)
            mHeaderText.text = eventModel.headerText
            mDescription.text = eventModel.description
            eventModel.place?.let { mContentPlace.text = it }
            eventModel.date?.let { mContentDate.text = it }
            eventModel.price?.let { mContentPrice.text = it }
        }
    }

}