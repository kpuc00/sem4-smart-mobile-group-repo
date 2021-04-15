package com.hills_studio.ui.members

import MembersListAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.hills_studio.MapsFragment
import com.hills_studio.R


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
        val btnOpenMap = root.findViewById<Button>(R.id.btnOpenMap)
        btnOpenMap.setOnClickListener {
            val mapsFragment: Fragment = MapsFragment()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(
                R.id.members_fragment,
                mapsFragment
            ) // give your fragment container id in first parameter

            transaction.addToBackStack(null) // if written, this transaction will be added to backstack

            transaction.commit()
        }

        return root
    }
}