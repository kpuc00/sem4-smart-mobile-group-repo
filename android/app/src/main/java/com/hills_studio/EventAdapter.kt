package com.hills_studio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.*

internal class EventAdapter internal constructor(
        context: Context,
        private val resource: Int,
        private val eventTitles: Array<String>?,
        private val eventDates: Array<String>?
) : ArrayAdapter<EventAdapter.ItemHolder>(context, resource) {

    override fun getCount(): Int {
        return if (this.eventTitles != null) this.eventTitles.size else 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val holder: ItemHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null)
            holder = ItemHolder()
            holder.eventTitle = convertView!!.findViewById(R.id.eventTitle)
            holder.eventDate = convertView.findViewById(R.id.eventDate)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ItemHolder
        }

        holder.eventTitle!!.text = this.eventTitles!![position]
        holder.eventDate!!.text = this.eventDates!![position]

        return convertView
    }

    internal class ItemHolder {
        var eventTitle: TextView? = null
        var eventDate: TextView? = null
    }
}
