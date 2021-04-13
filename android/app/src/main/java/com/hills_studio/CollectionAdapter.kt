package com.hills_studio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

internal class CollectionAdapter internal constructor(
        context: Context,
        private val resource: Int,
        private val collections: Array<String>?
) : ArrayAdapter<CollectionAdapter.ItemHolder>(context, resource) {

    override fun getCount(): Int {
        return if (this.collections != null) this.collections.size else 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val holder: ItemHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null)
            holder = ItemHolder()
            holder.collectionTitle = convertView!!.findViewById(R.id.collectionTxtVw)
            holder.collectionCover = convertView.findViewById(R.id.collectionImgVw)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ItemHolder
        }

        holder.collectionTitle!!.text = this.collections!![position]
        holder.collectionCover!!.setImageResource(R.drawable.collection_cover)

        return convertView
    }

    internal class ItemHolder {
        var collectionTitle: TextView? = null
        var collectionCover: ImageView? = null
    }
}
