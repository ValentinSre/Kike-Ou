package com.example.kike_ou.viewmodels

import androidx.lifecycle.*
import com.example.kike_ou.employee.Employee
import com.example.kike_ou.employee.EmployeeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import androidx.lifecycle.asLiveData

class EmployeeViewModel (private val repository: EmployeeRepository) : ViewModel()  {
    // update UI when agendas datachanges.
    // Repository separated from UI through ViewModel.

    private val scope = CoroutineScope(SupervisorJob())
    val allEmployees = repository.allEmployees.asLiveData()

    /**
     * insert the data in non-blocking coroutine
     */
    fun insertAgenda(agd: Employee) = scope.launch {
        repository.insert(agd)
    }

    fun getEmployee(emp: Employee) = scope.launch {
        repository.oneEmployee(emp.name,emp.week)
    }
}