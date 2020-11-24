package com.android.androidcertification

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ToastPrototype {

    private val duration = Toast.LENGTH_SHORT
    private val message = "this is hte toast"

    fun showToast(context: Context) {
        Toast.makeText(context, message, duration)
    }

    fun showCustomToast(layoutInflater: LayoutInflater, context: Context) {
        val layout = layoutInflater.inflate(R.layout.toast_layout, null)
        val textView = layout.findViewById<TextView>(R.id.toast_text)
        textView.text = "ceci est un toast"
        val imageView = layout.findViewById<ImageView>(R.id.toast_image)
        imageView.setImageResource(R.drawable.ic_toast_image)

        with(Toast(context)) {
            setGravity(Gravity.BOTTOM, 0, 0)
            duration = this.duration
            view = layout
            show()
        }
    }
}
