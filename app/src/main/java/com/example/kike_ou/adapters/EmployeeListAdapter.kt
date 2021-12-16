package com.example.kike_ou.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.kike_ou.databinding.RecycleviewItemBinding
import com.example.kike_ou.employee.Employee

class EmployeeListAdapter(): ListAdapter<Employee, EmployeeViewHolder>(AgendaDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var binding = RecycleviewItemBinding.inflate(inflater, parent, false)
        return EmployeeViewHolder.create(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val current: Employee? = getItem(position)
        val todisplay = current?.name
        val weekDisplay : Int? = current?.week
        val email : String? = current?.contact?.mail
        val tel : String? = current?.contact?.tel
        val fb : String? = current?.contact?.fb
        val agenda = current?.loc
        holder.bind(todisplay,weekDisplay,email,tel,fb,agenda)
    }

    internal class AgendaDiff : DiffUtil.ItemCallback<Employee>() {
        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.name.equals(newItem.name)
        }
    }
}