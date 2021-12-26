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
import org.json.JSONArray
import org.json.JSONException

import org.json.JSONObject
import java.text.Normalizer


class FormActivityEDT:AppCompatActivity() {

    private val REGEX_UNACCENT = "\\p{InCombiningDiacriticalMarks}+".toRegex()

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
        setContentView(R.layout.activity_form_edt)
        val GenQR : Button = findViewById(R.id.buttonGenQR)

        val editWeek : EditText = findViewById(R.id.editWeek)
        val editDay1 : EditText = findViewById(R.id.editDay1)
        val editDay2 : EditText = findViewById(R.id.editDay2)
        val editDay3 : EditText = findViewById(R.id.editDay3)
        val editDay4 : EditText = findViewById(R.id.editDay4)
        val editDay5 : EditText = findViewById(R.id.editDay5)

        GenQR.setOnClickListener{

            val semaine: String = editWeek.getText().toString()
            val jour1: String = editDay1.getText().toString().unaccent()
            val jour2: String = editDay2.getText().toString().unaccent()
            val jour3: String = editDay3.getText().toString().unaccent()
            val jour4: String = editDay4.getText().toString().unaccent()
            val jour5: String = editDay5.getText().toString().unaccent()

            val day1 = JSONObject()
            day1.put("day",1)
            day1.put("place",jour1)

            val day2 = JSONObject()
            day2.put("day",2)
            day2.put("place",jour2)

            val day3 = JSONObject()
            day3.put("day",3)
            day3.put("place",jour3)

            val day4 = JSONObject()
            day4.put("day",4)
            day4.put("place",jour4)

            val day5= JSONObject()
            day5.put("day",5)
            day5.put("place",jour5)

            val edtDic = mapOf("day 1" to jour1, "day2" to jour2, "day3" to jour3, "day4" to jour4, "day5" to jour5)

            val edt = JSONArray()
            edt.put(day1)
            edt.put(day2)
            edt.put(day3)
            edt.put(day4)
            edt.put(day5)

            println(edt)

            val json = JSONObject(intent.getStringExtra("ITEM_EXTRA"))

            try {
                json.put("week", semaine)
                json.put("loc", edt)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            val qrGeneratorActivity = Intent(this,QRGeneratorActivity::class.java)
            qrGeneratorActivity.putExtra("ITEM_EXTRA", json.toString());

            startActivity(qrGeneratorActivity)
        }


    }
    fun CharSequence.unaccent(): String {
        val temp = Normalizer.normalize(this, Normalizer.Form.NFD)
        return REGEX_UNACCENT.replace(temp, "")
    }
}