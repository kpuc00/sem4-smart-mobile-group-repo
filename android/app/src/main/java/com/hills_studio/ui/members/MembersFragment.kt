package com.hills_studio.ui.members

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hills_studio.R
import com.hills_studio.User
import com.hills_studio.getJsonDataFromAsset

class MembersFragment : Fragment() {

    //private lateinit var membersViewModel: MembersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        membersViewModel =
//            ViewModelProvider(this).get(MembersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_members, container, false)

        val lvMembers: ListView = root.findViewById(R.id.lvMembers)
        val jsonFileString =
            activity?.let { getJsonDataFromAsset(it.applicationContext, "users.json") }
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }

        val gson = Gson()
        val listUserType = object : TypeToken<List<User>>() {}.type

        val users: List<User> = gson.fromJson(jsonFileString, listUserType)
//        users.forEachIndexed { idx, user -> Log.i("data", "> Item $idx:\n$user") }
        lvMembers.adapter = activity?.applicationContext?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_list_item_1 , users)
        }

//        membersViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}