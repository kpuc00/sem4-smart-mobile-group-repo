package com.hills_studio.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hills_studio.CollectionAdapter
import com.hills_studio.EventAdapter
import com.hills_studio.R
import com.hills_studio.ui.collections.CollectionsViewModel

class EventsFragment : Fragment(){
//    private lateinit var eventsViewModel: EventsViewModel
    private val eventTitleList: Array<String>
        get() = resources.getStringArray(R.array.eventTitleFakeData)
    private val eventDateList: Array<String>
        get() = resources.getStringArray(R.array.eventDateFakeData)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_events, container, false)
        val gvEvents = root.findViewById<GridView>(R.id.gvEvents)

        val adapter = activity?.applicationContext?.let {
            EventAdapter(
                    it,
                    R.layout.event_item,
                    eventTitleList,
                    eventDateList
            )
        }
        gvEvents.adapter = adapter
        return root
    }
}