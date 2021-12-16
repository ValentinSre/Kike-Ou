package com.example.kike_ou.employee

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.kike_ou.employee.Employee
import com.example.kike_ou.employee.EmployeeDAO
import com.example.kike_ou.json.ListLocationConverter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@TypeConverters(ListLocationConverter::class)
@Database(entities = [Employee::class], version = 1)
abstract class EmployeeRoomDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDAO

    companion object {
        @Volatile
        private var INSTANCE: EmployeeRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): EmployeeRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val aux = Room.databaseBuilder(
                    context.applicationContext,
                    EmployeeRoomDatabase::class.java,
                    "employee_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(AgendaDatabaseCallback(scope))
                    .build()

                INSTANCE = aux
                aux
            }
        }

        private class AgendaDatabaseCallback(val scope: CoroutineScope) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        //populate(database.employeeDao())
                    }
                }
            }
        }

        /* populate db in coroutine
        suspend fun populate(employeeDAO: EmployeeDAO) {
            employeeDAO.deleteAll()
            var contact = Contact("guillaume.chatelet@orange.com", null, null)
            var location = arrayListOf<Location>(Location(2, "en TT"),Location(5, "en TT"))
            var agenda = Employee("guillaume chatelet", 47,location, contact)
            employeeDAO.insert(agenda)

            contact = Contact("pierre.crepieux@orange.com", null, null)
            location = arrayListOf<Location>(Location(3, "en TT"),Location(4, "en TT"))
            agenda = Employee("pierre crepieux",  47,location, contact)
            employeeDAO.insert(agenda)
        }*/
    }
}