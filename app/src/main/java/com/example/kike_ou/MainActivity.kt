package com.example.kike_ou

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val QrcodeGen = Intent(this,QRGeneratorActivity::class.java)

        val boutonGenQR : Button = findViewById(R.id.buttonGenQR)

        boutonGenQR.setOnClickListener{
            startActivity(QrcodeGen)
        }
    }
}