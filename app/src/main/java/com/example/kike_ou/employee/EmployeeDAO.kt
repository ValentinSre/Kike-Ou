package com.example.kike_ou.employee
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface EmployeeDAO {

    @Query("SELECT * FROM employee_table ORDER BY id ASC")
    fun getAllEmployees(): Flow<List<Employee>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(employee: Employee)

    @Query("DELETE FROM employee_table")
    suspend fun deleteAll()

    @Query("DELETE FROM employee_table WHERE id= :id")
    suspend fun deleteEmployee(id: Int)

    @Query("SELECT * from employee_table where name= :nom")
    suspend fun getEmployeeByName(nom: String): Employee
}

