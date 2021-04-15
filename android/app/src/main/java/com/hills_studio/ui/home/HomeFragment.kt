package com.hills_studio.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hills_studio.R


class HomeFragment : Fragment() {

    private val rotateOpen: Animation by lazy{AnimationUtils.loadAnimation(context, R.anim.rotate_open_anim)}
    private val rotateClose: Animation by lazy{AnimationUtils.loadAnimation(context, R.anim.rotate_close_anim)}
    private val fromBottom: Animation by lazy{AnimationUtils.loadAnimation(context, R.anim.from_bottom_anim)}
    private val toBottom: Animation by lazy{AnimationUtils.loadAnimation(context, R.anim.to_bottom_anim)}

    private var addBtnClicked = false

    private lateinit var addBtn: FloatingActionButton
    private lateinit var textBtn:FloatingActionButton
    private lateinit var voiceBtn:FloatingActionButton
    private lateinit var imageBtn:FloatingActionButton
    private lateinit var videoBtn:FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        addBtn = root.findViewById<FloatingActionButton>(R.id.addBtn)
        textBtn = root.findViewById<FloatingActionButton>(R.id.textBtn)
        voiceBtn = root.findViewById<FloatingActionButton>(R.id.voiceBtn)
        imageBtn = root.findViewById<FloatingActionButton>(R.id.imageBtn)
        videoBtn = root.findViewById<FloatingActionButton>(R.id.videoBtn)

        addBtn.setOnClickListener{addBtnClicked()}
        textBtn.setOnClickListener{textAction()}
        voiceBtn.setOnClickListener{voiceAction()}
        imageBtn.setOnClickListener{imageAction()}
        videoBtn.setOnClickListener{videoAction()}


        return root
    }

    private fun addBtnClicked() {
        setVisibility(addBtnClicked)
        setAnimation(addBtnClicked)
        setClickable(addBtnClicked)
        addBtnClicked = !addBtnClicked
    }

    private fun setClickable(clicked: Boolean) {
        if (!clicked){
            textBtn.isClickable = true
            voiceBtn.isClickable = true
            imageBtn.isClickable = true
            videoBtn.isClickable = true
        }else{
            textBtn.isClickable = false
            voiceBtn.isClickable = false
            imageBtn.isClickable = false
            videoBtn.isClickable = false
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked){
            textBtn.startAnimation(fromBottom)
            voiceBtn.startAnimation(fromBottom)
            imageBtn.startAnimation(fromBottom)
            videoBtn.startAnimation(fromBottom)
            addBtn.startAnimation(rotateOpen)

        }else{
            textBtn.startAnimation(toBottom)
            voiceBtn.startAnimation(toBottom)
            imageBtn.startAnimation(toBottom)
            videoBtn.startAnimation(toBottom)
            addBtn.startAnimation(rotateClose)
        }
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked){
            textBtn.visibility = View.VISIBLE
            voiceBtn.visibility = View.VISIBLE
            imageBtn.visibility = View.VISIBLE
            videoBtn.visibility = View.VISIBLE

        }else{
            textBtn.visibility = View.INVISIBLE
            voiceBtn.visibility = View.INVISIBLE
            imageBtn.visibility = View.INVISIBLE
            videoBtn.visibility = View.INVISIBLE
        }
    }

    private fun videoAction() {
        val toast = Toast.makeText(context, "video", Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun imageAction() {
        val toast = Toast.makeText(context, "image", Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun voiceAction() {
        val toast = Toast.makeText(context, "voice", Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun textAction() {
        val toast = Toast.makeText(context, "text", Toast.LENGTH_SHORT)
        toast.show()
    }
}