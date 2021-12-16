package com.example.kike_ou

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil.setContentView
import org.json.JSONException

import org.json.JSONObject


class FormActivity:AppCompatActivity() {

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
        setContentView(R.layout.activity_form)
        val GenQR : Button = findViewById(R.id.buttonGenQR)
        val editName : EditText = findViewById (R.id.editName)
        val editMail : EditText = findViewById (R.id.editMail)
        val editTel : EditText = findViewById (R.id.editTel)
        val editFacebook : EditText = findViewById(R.id.editFacebook)


        GenQR.setOnClickListener{

            val nom: String = editName.getText().toString()
            val adresse: String = editMail.getText().toString()
            val tel: String = editTel.getText().toString()
            val facebook: String = editFacebook.getText().toString()

            val contactDic = mapOf("email" to adresse, "tel" to tel, "fb" to facebook)

            val json = JSONObject()
            try {
                json.put("name", nom)
                json.put("contact", contactDic)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            val EDTActivity = Intent(this,FormActivityEDT::class.java)
            EDTActivity.putExtra("ITEM_EXTRA", json.toString());

            startActivity(EDTActivity)
        }

    }
}