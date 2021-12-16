package com.example.kike_ou

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kike_ou.adapters.EmployeeListAdapter
import com.example.kike_ou.databinding.ActivityListBinding
import com.example.kike_ou.employee.Employee
import com.example.kike_ou.employee.EmployeeRepository
import com.example.kike_ou.employee.EmployeeRoomDatabase
import com.example.kike_ou.viewmodels.EmployeeViewModel
import com.example.kike_ou.viewmodels.EmployeeViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.onEach

class ListActivity : AppCompatActivity() {

    private lateinit var _employeeViewModel: EmployeeViewModel

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.activity_menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        val QR_scan = Intent(this, QRScanActivity::class.java)

        when (item?.itemId)
        {
            R.id.scanButton ->
            {
                startActivity(QR_scan)
            }

        }
        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())

        val adapter = EmployeeListAdapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        val scope = CoroutineScope(SupervisorJob())
        val database = EmployeeRoomDatabase.getDatabase(this, scope)
        val repository = EmployeeRepository(database.employeeDao())

        // Get a new or existing ViewModel using Agenda view model factory.
        _employeeViewModel = ViewModelProvider(
            this,
            EmployeeViewModelFactory(repository)
        ).get(EmployeeViewModel::class.java)
        _employeeViewModel.allEmployees.observe(this) { employees ->
            adapter.submitList(employees)
        }


    }
}