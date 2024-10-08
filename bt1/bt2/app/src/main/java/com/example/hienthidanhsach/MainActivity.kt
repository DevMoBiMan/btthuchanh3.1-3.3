package com.example.hienthidanhsach

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModeRadioGroup: RadioGroup
    private lateinit var listViewRadioButton: RadioButton
    private lateinit var gridViewRadioButton: RadioButton
    private lateinit var confirmButton: Button
    private lateinit var fruitAdapter: FruitAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Khởi tạo dữ liệu danh sách trái cây
        val fruits = listOf(
            Fruit("Táo"),
            Fruit("Cam"),
            Fruit("Chuối"),
            Fruit("Dứa"),
            Fruit("Xoài"),
            Fruit("Dưa hấu"),
            Fruit("Lê"),
            Fruit("Bưởi")
        )
// Liên kết các thành phần giao diện
        recyclerView = findViewById(R.id.recyclerView)
        viewModeRadioGroup = findViewById(R.id.viewModeRadioGroup)
        listViewRadioButton = findViewById(R.id.listViewRadioButton)
        gridViewRadioButton = findViewById(R.id.gridViewRadioButton)
        confirmButton = findViewById(R.id.confirmButton)
// Thiết lập adapter cho RecyclerView
        fruitAdapter = FruitAdapter(fruits)
        recyclerView.adapter = fruitAdapter

        // Mặc định sử dụng LinearLayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Thay đổi chế độ xem khi người dùng chọn List hoặc Grid
        viewModeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.listViewRadioButton) {
                recyclerView.layoutManager = LinearLayoutManager(this)
            } else if (checkedId == R.id.gridViewRadioButton) {
                recyclerView.layoutManager = GridLayoutManager(this, 2)
            }
        }

        // Khi nhấn nút "Xác nhận lựa chọn"
        confirmButton.setOnClickListener {
            val selectedFruits = fruits.filter { it.isSelected }.joinToString { it.name }
            Toast.makeText(this, "Bạn đã chọn: $selectedFruits",
                Toast.LENGTH_SHORT).show()
        }
    }
}