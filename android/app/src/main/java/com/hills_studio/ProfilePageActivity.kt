package com.hills_studio

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class ProfilePageActivity : AppCompatActivity() {
    private val hobbiesList: Array<String>
        get() = arrayOf(
            "Football",
            "Painting",
            "Fishing",
            "Hiking",
            "Sailing"
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        val gvHobbies = findViewById<GridView>(R.id.gvHobbies)
        val adapter = HobbiesListAdapter(this, R.layout.item_hobby, hobbiesList)
        gvHobbies.adapter = adapter
    }
}