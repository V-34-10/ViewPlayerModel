package com.vandr.playerview

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AlphaAnimation
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_player_view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton()
        Log.d(ContentValues.TAG, "onCreate")
    }

    private fun clickButton() {
        val alphaAnimation = AlphaAnimation(1.0f, 0.0f)
        alphaAnimation.duration = 2000
        button1.setOnClickListener {
            button1.startAnimation(alphaAnimation)
            setContentView(R.layout.activity_linear)
        }
        button2.setOnClickListener {
            button2.startAnimation(alphaAnimation)
            setContentView(R.layout.activity_frame)
        }
        button3.setOnClickListener {
            button3.startAnimation(alphaAnimation)
            setContentView(R.layout.activity_constraint)
        }
        button_customView.setOnClickListener {
            val intent = Intent(this, ViewActivity::class.java)
            startActivity(intent)
            button_customView.startAnimation(alphaAnimation)
            finish()
        }
    }
    @Deprecated("Deprecated in Java", ReplaceWith("setContentView(R.layout.activity_main)"))
    override fun onBackPressed() {
        setContentView(root)
    }
}