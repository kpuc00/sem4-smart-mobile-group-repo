package com.hills_studio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

internal class HobbiesListAdapter internal constructor(
    context: Context,
    private val resource: Int,
    private val hobbiesList: Array<String>?
) : ArrayAdapter<HobbiesListAdapter.ItemHolder>(context, resource) {

    override fun getCount(): Int {
        return if (this.hobbiesList != null) this.hobbiesList.size else 0
    }

    override fun getView(position: Int, givenConvertView: View?, parent: ViewGroup): View {
        var convertView = givenConvertView

        val holder: ItemHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null)
            holder = ItemHolder()
            holder.hobbyTitle = convertView!!.findViewById(R.id.hobbyTitle)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ItemHolder
        }

        holder.hobbyTitle!!.text = this.hobbiesList!![position]

        return convertView
    }

    internal class ItemHolder {
        var hobbyTitle: TextView? = null
    }
}
