package com.example.day16_smarthomeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.day16_smarthomeapp.databinding.ItemviewBinding

class CategoryAdapter(private val categoryList: List<String>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){
    class ViewHolder(binding: ItemviewBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView = binding.category
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoryList[position]
        holder.textView.text = category
    }


}