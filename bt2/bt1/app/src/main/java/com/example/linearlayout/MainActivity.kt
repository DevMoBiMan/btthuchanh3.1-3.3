package com.example.linearlayout

import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton: Button = findViewById(R.id.submitButton)
        val edho: EditText = findViewById(R.id.lastNameEditText)
        val edten: EditText = findViewById(R.id.firstNameEditText)

        submitButton.setOnClickListener{
            val ho = edho.text.toString()
            val ten = edten.text.toString()
            Toast.makeText(this, "Họ và tên: $ho $ten", Toast.LENGTH_SHORT).show()
        }

    }
}