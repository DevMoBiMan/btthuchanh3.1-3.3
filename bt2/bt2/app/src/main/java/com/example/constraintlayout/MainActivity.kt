package com.example.constraintlayout

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAccept: Button = findViewById(R.id.acceptButton)
        val btnCancel: Button = findViewById(R.id.cancelButton)
        val textView: TextView = findViewById(R.id.responseTextView)

        btnAccept.setOnClickListener {
            textView.text = "Đã chấp nhận"
        }

        btnCancel.setOnClickListener {
            textView.text = "Đã hủy"
        }

    }
}