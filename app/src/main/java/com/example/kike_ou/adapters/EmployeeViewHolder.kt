package com.example.kike_ou.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.kike_ou.databinding.RecycleviewItemBinding
import com.example.kike_ou.employee.Location

class EmployeeViewHolder private constructor(var binding: RecycleviewItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(value: String?,week: Int?,email:String?,tel:String?,fb:String?,agenda:List<Location>?) {
        binding.employeeItem.text = value
        binding.weekItem.text="Semaine : $week"
        binding.mail.text=email
        binding.tel.text=tel
        binding.fb.text="Facebook : $fb"
        val agn = agenda
        binding.valLundi.text=agn?.get(0)?.place
        binding.valMardi.text=agn?.get(1)?.place
        binding.valMercredi.text=agn?.get(2)?.place
        binding.valJeudi.text=agn?.get(3)?.place
        binding.valVendredi.text=agn?.get(4)?.place
    }

    companion object {
        fun create(binding: RecycleviewItemBinding): EmployeeViewHolder {
            return EmployeeViewHolder(binding)
        }
    }

}