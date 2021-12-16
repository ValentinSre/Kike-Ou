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
import com.example.kike_ou.employee.Location
import com.example.kike_ou.json.ListLocationConverter
import org.json.JSONArray
import org.json.JSONException

import org.json.JSONObject
import java.text.Normalizer


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

            val nom: String = Normalizer.normalize(editName.getText().toString(),Normalizer.Form.NFD)
            val adresse:String = Normalizer.normalize(editMail.getText().toString(),Normalizer.Form.NFD)
            val tel: String = editTel.getText().toString()
            val facebook: String = Normalizer.normalize(editFacebook.getText().toString(),Normalizer.Form.NFD)


            val contact = JSONObject()
            contact.put("mail",adresse)
            contact.put("tel",tel)
            contact.put("fb",facebook)


            val json = JSONObject()
            try {
                json.put("name", nom)
                json.put("contacts", contact)

            } catch (e: JSONException) {
                e.printStackTrace()
            }
            val EDTActivity = Intent(this,FormActivityEDT::class.java)
            EDTActivity.putExtra("ITEM_EXTRA", json.toString());

            startActivity(EDTActivity)
        }

    }
}