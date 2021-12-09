package com.example.kike_ou

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.view.Menu

import android.view.MenuItem


class MainActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_main)
        val addUser : Button = findViewById(R.id.addUser)
        val userList: Button = findViewById(R.id.userList)

        addUser.setOnClickListener{
            val QRGenIntent = Intent(this,QRGeneratorActivity::class.java)
            startActivity(QRGenIntent)

        }

        userList.setOnClickListener{
            val UserListIntent = Intent(this,QRGeneratorActivity::class.java)
            startActivity(UserListIntent)
        }



    }
}