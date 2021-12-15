package com.example.kike_ou.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.kike_ou.databinding.RecyclerviewItemBinding

class EmployeeViewHolder private constructor(var binding: RecyclerviewItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(value: String?) {
        binding.agendaItem.text = value
    }

    companion object {
        fun create(binding: RecyclerviewItemBinding): EmployeeViewHolder {
            return EmployeeViewHolder(binding)
        }
    }

}