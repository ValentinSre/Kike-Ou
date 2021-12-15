package com.example.kike_ou.employee

import androidx.annotation.WorkerThread

class EmployeeRepository(private val dao: EmployeeDAO) {
    val allEmployees= dao.getAllEmployees()

    // call on a non-UI thread
    @WorkerThread
    suspend fun insert(employee: Employee) {
        dao.insert(employee)
    }
}
