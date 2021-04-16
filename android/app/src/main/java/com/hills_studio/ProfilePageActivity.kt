package com.hills_studio

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

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

        val settingsBtn: ImageView = findViewById(R.id.toolbar_settings)

        settingsBtn.setOnClickListener{
            intent = Intent(applicationContext, SettingsActivity::class.java)
            startActivity(intent)
        }

        val profilePic = findViewById<ImageView>(R.id.profilePic)
        Picasso.get().load("https://robohash.org/tenetursuntminus.png?size=50x50&set=set1")
            .into(profilePic)

        val gvHobbies = findViewById<GridView>(R.id.gvHobbies)
        val adapter = HobbiesListAdapter(this, R.layout.item_hobby, hobbiesList)
        gvHobbies.adapter = adapter
    }

}