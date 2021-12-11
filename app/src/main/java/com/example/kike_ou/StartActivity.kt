package com.example.kike_ou

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val mainActivity = Intent(this,MainActivity::class.java)

        val boutonStart : ImageView = findViewById(R.id.logo)

        boutonStart.setOnClickListener{
            startActivity(mainActivity)
        }

    }
}