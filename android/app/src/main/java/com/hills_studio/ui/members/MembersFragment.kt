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
import com.hills_studio.User

class MembersFragment : Fragment() {

    //private lateinit var membersViewModel: MembersViewModel

    var membersList: ArrayList<User> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        membersViewModel =
//            ViewModelProvider(this).get(MembersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_members, container, false)

        membersList.add(User("Nance Reddington", "https://robohash.org/mollitiavelitasperiores.png?size=50x50&set=set1"))
        membersList.add(User("Stanly Tetlow", "https://robohash.org/tenetursuntminus.png?size=50x50&set=set1"))
        membersList.add(User("Josh Hasnip", "https://robohash.org/auttemporerecusandae.png?size=50x50&set=set1"))
        membersList.add(User("Gabbie Condell", "https://robohash.org/idvoluptastenetur.png?size=50x50&set=set1"))
        membersList.add(User("Filberto Britto", "https://robohash.org/doloreetquia.png?size=50x50&set=set1"))
        membersList.add(User("Maggee Gittings", "https://robohash.org/nesciunteiussimilique.png?size=50x50&set=set1"))
        membersList.add(User("Conni Linforth", "https://robohash.org/facilisillodolore.png?size=50x50&set=set1"))
        membersList.add(User("Stearne McHugh", "https://robohash.org/modiquisquamfuga.png?size=50x50&set=set1"))
        membersList.add(User("Friedrick Nellen", "https://robohash.org/sequiipsalaudantium.png?size=50x50&set=set1"))
        membersList.add(User("Lorettalorna de Merida", "https://robohash.org/nequeetvoluptas.png?size=50x50&set=set1"))

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