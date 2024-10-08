package com.example.simpleuiapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Liên kết các thành phần giao diện với mã Kotlin
        val greetingTextView: TextView = findViewById(R.id.greetingTextView)
        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val submitButton: Button = findViewById(R.id.submitButton)
        val imageView: ImageView = findViewById(R.id.imageView)

        // Thiết lập sự kiện khi bấm nút Button
        submitButton.setOnClickListener {
            val name = nameEditText.text.toString() // Lấy tên từ EditText
            if (name.isNotEmpty()) {
                // Hiển thị lời chào với tên người dùng
                greetingTextView.text = "Xin chào, $name!"
            } else {
                // Hiển thị thông báo nếu người dùng chưa nhập tên
                greetingTextView.text = "Xin hãy nhập tên của bạn."
            }
        }
    }
}