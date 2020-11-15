package com.android.androidcertification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val duration = Toast.LENGTH_SHORT
    private val message = "this is hte toast"
    private lateinit var customToastButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customToastButton = findViewById(R.id.custom_toast_button)
        customToastButton.setOnClickListener {
            showCustomToast()
        }
    }

    private fun showCustomToast() {
        val layout = layoutInflater.inflate(R.layout.toast_layout, null)
        val textView = layout.findViewById<TextView>(R.id.toast_text)
        textView.text = "ceci est un toast"
        val imageView = layout.findViewById<ImageView>(R.id.toast_image)
        imageView.setImageResource(R.drawable.ic_toast_image)

        with(Toast(applicationContext)) {
            setGravity(Gravity.BOTTOM, 0, 0)
            duration = this.duration
            view = layout
            show()
        }

    }

    override fun onResume() {
        super.onResume()
        showToast()
    }

    private fun showToast() {
        Toast.makeText(this, message, duration)
    }
}