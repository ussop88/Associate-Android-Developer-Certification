package com.android.androidcertification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var customToastButton: Button
    private val toastPrototype = ToastPrototype()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customToastButton = findViewById(R.id.custom_toast_button)
        customToastButton.setOnClickListener {
            toastPrototype.showCustomToast(layoutInflater, applicationContext)
        }
    }

    override fun onResume() {
        super.onResume()
        layoutInflater
        toastPrototype.showToast(this)
    }
}