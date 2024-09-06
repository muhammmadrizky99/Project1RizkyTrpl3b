package com.rizky.project1rizkytrpl3b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class TigaActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    val pilSatuan = arrayOf<String>("Box","Lusin","Buah","Kg","Gram","Bungkus")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiga)
        val name = findViewById<EditText>(R.id.editProductName)
        val jumlah = findViewById<EditText>(R.id.jmlProduct)
        val price = findViewById<EditText>(R.id.editProductPrice)
        val proses = findViewById<Button>(R.id.btnProcess)


        val satuan = findViewById<Spinner>(R.id.spinSatuan)
        satuan.onItemSelectedListener=this
        val pilihanSatuan = ArrayAdapter(this@TigaActivity,
            R.layout.spinner_style, pilSatuan)
        pilihanSatuan.setDropDownViewResource(R.layout.spinner_style)
        satuan.adapter=pilihanSatuan
        proses.setOnClickListener {
            val jumlahValue = jumlah.text.toString().toDoubleOrNull() ?: 0.0
            val priceValue = price.text.toString().toDoubleOrNull() ?: 0.0

            val total = priceValue * jumlahValue
            val bundle = Bundle()
            bundle.putString("nameProduct", name.text.toString())
            bundle.putString("priceProduct", price.text.toString())
            bundle.putString("satuanProduct", satuan.selectedItem.toString())
            bundle.putString("jumlahProduct", jumlah.text.toString())
            bundle.putString("totalProduct", total.toString())

            Log.d("TigaActivity", "Total Product: $total")

            val intent =  Intent(this@TigaActivity,
                EmpatActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val spinnerSatuan:String = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this,"Satuan : $pilSatuan", Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}