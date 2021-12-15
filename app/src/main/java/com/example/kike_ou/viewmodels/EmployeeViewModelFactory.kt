package com.example.kike_ou.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kike_ou.employee.EmployeeRepository

class EmployeeViewModelFactory(private val repository: EmployeeRepository): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    //factory created to pass repository to view model...
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeeViewModel(repository) as T
    }
}