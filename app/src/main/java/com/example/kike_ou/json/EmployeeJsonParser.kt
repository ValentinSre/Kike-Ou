package com.example.kike_ou.json

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.example.kike_ou.employee.Employee

class EmployeeJsonParser {

    companion object {
        fun parseEmployee(json: String): Employee? {
            val moshi = Moshi.Builder().build()
            val adapter: JsonAdapter<Employee> = moshi.adapter(Employee::class.java)
            return adapter.fromJson(json)
        }
    }

}