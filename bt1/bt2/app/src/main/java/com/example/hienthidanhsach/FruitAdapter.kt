package com.example.hienthidanhsach

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class FruitAdapter(private val fruits: List<Fruit>) :
    RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {
    class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fruitNameTextView: TextView =
            itemView.findViewById(R.id.fruitNameTextView)
        val fruitCheckBox: CheckBox = itemView.findViewById(R.id.fruitCheckBox)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            FruitViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_fruit,
            parent, false)
        return FruitViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val fruit = fruits[position]
        holder.fruitNameTextView.text = fruit.name
        holder.fruitCheckBox.isChecked = fruit.isSelected
// Khi người dùng thay đổi trạng thái checkbox
        holder.fruitCheckBox.setOnCheckedChangeListener { _, isChecked ->
            fruit.isSelected = isChecked
        }
    }
    override fun getItemCount() = fruits.size
}