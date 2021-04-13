package com.hills_studio.ui.collections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.hills_studio.CollectionAdapter
import com.hills_studio.R

class CollectionsFragment : Fragment() {

//    private lateinit var collectionsViewModel: CollectionsViewModel
    private val collectionList: Array<String>
    get() = resources.getStringArray(R.array.collectionFakeData)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_collections, container, false)
        val gvCollections = root.findViewById<GridView>(R.id.gvCollections)

        val adapter = activity?.applicationContext?.let {
            CollectionAdapter(
                    it,
                    R.layout.collection_item,
                    collectionList
            )
        }
        gvCollections.adapter = adapter
        return root
    }
}