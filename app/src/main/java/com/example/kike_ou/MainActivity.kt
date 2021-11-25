package com.example.kike_ou

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kike_ou.QRScanActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val QrcodeGen = Intent(this,QRGeneratorActivity::class.java)
        val QR_scan = Intent(this, QRScanActivity::class.java)

        val boutonGenQR : Button = findViewById(R.id.buttonGenQR)
        val boutonCamera : Button = findViewById(R.id.camera_button)


        boutonGenQR.setOnClickListener{
            startActivity(QrcodeGen)
        }

        boutonCamera.setOnClickListener{
            startActivity(QR_scan)
        }
    }
}