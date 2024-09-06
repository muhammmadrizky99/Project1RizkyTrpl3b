package com.rizky.project1rizkytrpl3b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class EmpatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empat)
        val result = findViewById<TextView>(R.id.txtResult)
        val total = findViewById<TextView>(R.id.txtTotal)
        val bundle = intent.extras
        if (bundle != null) {
            val totalProduct = bundle.getString("totalProduct", "0")?.toDoubleOrNull() ?: 0.0

            Log.d("EmpatActivity", "Received Total Product: $totalProduct")

            result.text = "Minimarket Transaction" +
                    "\nProduct Name :${bundle.getString("nameProduct")}" +
                    "\nProduct Price :${bundle.getString("priceProduct")}" +
                    "\nSatuan Product :${bundle.getString("satuanProduct")}"+
                    "\nJumlah Product : ${bundle.getString("jumlahProduct")}"

            total.text = "Total Keseluruhan: $totalProduct"


        }

    }
}