package com.example.kike_ou.employee

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.URL
import java.util.*

@Entity(tableName = "employee_table")

data class Employee(@PrimaryKey @ColumnInfo(name = "id") val id: String,
                    @ColumnInfo(name="name") val nom: String,
                    @ColumnInfo(name="photo") val photo: URL,
                    @ColumnInfo(name="contact") val contact: Dictionary<String, String>,
                    @ColumnInfo(name="week") val week: Int,
                    @ColumnInfo(name="loc") val loc: Dictionary<Int, String>
    )