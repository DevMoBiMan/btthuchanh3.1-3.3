package com.example.changeedittext

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Liên kết các thành phần giao diện
        val inputEditText: EditText = findViewById(R.id.inputEditText)
        val outputTextView: TextView = findViewById(R.id.outputTextView)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
// Khởi tạo danh sách trái cây
        val fruits = listOf("Táo", "Cam", "Chuối", "Dưa hấu", "Xoài")
        val adapter = FruitAdapter(fruits) { selectedFruit ->
            Toast.makeText(this, "Bạn đã chọn: $selectedFruit",
                Toast.LENGTH_SHORT).show()
        }
// Thiết lập RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
// Theo dõi sự thay đổi trong EditText
        inputEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
// Cập nhật TextView với nội dung mới
                outputTextView.text = "Bạn vừa nhập: ${s.toString()}"
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after:
            Int) {}
            {}
        }
    })
}
override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
// Adapter cho RecyclerView
class FruitAdapter(
    private val fruits: List<String>,
    private val itemClickListener: (String) -> Unit
) : RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {
    class FruitViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            FruitViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false) as TextView
        return FruitViewHolder(textView)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val fruit = fruits[position]
        holder.textView.text = fruit
        holder.textView.setOnClickListener {
            itemClickListener(fruit)
        }
    }

    override fun getItemCount() = fruits.size
}