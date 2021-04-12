package com.hills_studio.ui.members

import MembersListAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import com.hills_studio.R
import com.hills_studio.getJsonDataFromAsset

class MembersFragment : Fragment() {

    //private lateinit var membersViewModel: MembersViewModel

    private val membersList: Array<String>
        get() = arrayOf(
            "Nance Reddington",
            "Stanly Tetlow",
            "Josh Hasnip",
            "Gabbie Condell",
            "Filberto Britto",
            "Maggee Gittings",
            "Conni Linforth",
            "Stearne McHugh",
            "Friedrick Nellen",
            "Lorettalorna de Merida"
        )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        membersViewModel =
//            ViewModelProvider(this).get(MembersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_members, container, false)

        val jsonFileString =
            activity?.let { getJsonDataFromAsset(it.applicationContext, "users.json") }
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }

//        val gson = Gson()
//        val listUserType = object : TypeToken<List<User>>() {}.type☻

//        val users: List<User> = gson.fromJson(jsonFileString, listUserType)
//        users.forEachIndexed { idx, user -> Log.i("data", "> Item $idx:\n$user") }

        val gvMembers = root.findViewById<GridView>(R.id.gvMembers)
        val adapter = activity?.applicationContext?.let {
            MembersListAdapter(
                it,
                R.layout.item_member,
                membersList
            )
        }
        gvMembers.adapter = adapter

//        membersViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}