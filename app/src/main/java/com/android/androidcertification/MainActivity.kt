package com.android.androidcertification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val duration = Toast.LENGTH_SHORT
    private val message = "this is hte toast"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        showToast()
    }

    private fun showToast() {
        Toast.makeText(this, message, duration)
    }
}