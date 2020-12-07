package com.android.androidcertification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var customToastButton: Button
    private lateinit var root: ConstraintLayout
    private val toastPrototype = ToastPrototype()
    private lateinit var welcomeText: TextView
    private lateinit var notificationBuilder: NotificationBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customToastButton = findViewById(R.id.custom_toast_button)
        welcomeText = findViewById(R.id.welcome_text_holder)
        root = findViewById(R.id.main_activity_layout)
        customToastButton.setOnClickListener {
            with(Snackbar.make(root, "message", 3000)) {
                setAction("action") {
                }
                setBackgroundTint(getColor(R.color.blue))
                show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        NotificationBuilder(this).apply {
            createNotificationChannel()
            show()
        }
        layoutInflater
        toastPrototype.showToast(this)
    }
}