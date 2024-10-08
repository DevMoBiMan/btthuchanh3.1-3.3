package com.example.sulysukien

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClick: Button = findViewById(R.id.pressButton)
        val btnLongClick: Button = findViewById(R.id.longPressButton)

        btnClick.setOnClickListener {
            Toast.makeText(this, "Bạn đã nhấn nút", Toast.LENGTH_SHORT).show()
        }

        btnLongClick.setOnLongClickListener {
            Toast.makeText(this, "Bạn đang nhấn giữ nút", Toast.LENGTH_LONG).show()
            true // Trả về true để biểu thị rằng sự kiện đã được xử lý
        }
    }
}