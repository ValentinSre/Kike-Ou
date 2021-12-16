package com.example.kike_ou

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EmployeeActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_employee)

        val valueLundi: TextView = findViewById(R.id.valLundi)
        val valueMardi: TextView = findViewById(R.id.valMardi)
        val valueMercredi: TextView = findViewById(R.id.valMercredi)
        val valueJeudi: TextView = findViewById(R.id.valJeudi)
        val valueVendredi: TextView = findViewById(R.id.valVendredi)


    }
}