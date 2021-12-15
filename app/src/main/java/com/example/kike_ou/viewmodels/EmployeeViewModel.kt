package com.example.kike_ou.viewmodels

import androidx.lifecycle.ViewModel
import com.example.kike_ou.employee.Employee
import com.example.kike_ou.employee.EmployeeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class EmployeeViewModel (private val repository: EmployeeRepository) : ViewModel()  {
    // update UI when agendas datachanges.
    // Repository separated from UI through ViewModel.
    val allEmployees = repository.allEmployees

    private val scope = CoroutineScope(SupervisorJob())

    /**
     * insert the data in non-blocking coroutine
     */
    fun insertAgenda(agd: Employee) = scope.launch {
        repository.insert(agd)
    }
}