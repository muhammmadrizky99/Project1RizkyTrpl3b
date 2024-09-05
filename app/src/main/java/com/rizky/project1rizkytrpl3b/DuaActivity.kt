package com.rizky.project1rizkytrpl3b

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class DuaActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    //: =>extends (pewarisan/inherits)
    //, =>implements (interface)
    val pilBerangkat = arrayOf<String>("06.00 pm", "06.00 am", "07.00 pm", "08.00 am", "09.00 pm", "10.00 am", "11.00 pm" , "12.00 am", "01.00 pm", "02.00 am")
    lateinit var rbBayar : RadioButton
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dua)
        val makanan =  findViewById<CheckBox>(R.id.chkMakanan)
        val executive = findViewById<CheckBox>(R.id.chkExcekute)
        val bagasi = findViewById<CheckBox>(R.id.chkBagasi)
        val bayar = findViewById<RadioGroup>(R.id.rgBayar)
        val tujuan = findViewById<EditText>(R.id.editTujuan)
        val harga = findViewById<EditText>(R.id.editHarga)
        val jumlah = findViewById<EditText>(R.id.editJumlah)
        val proses =  findViewById<Button>(R.id.btnProses)
        val trans =  findViewById<TextView>(R.id.txtTrans)
        val spinBerangkat = findViewById<Spinner>(R.id.spinkeberangkatan)
        spinBerangkat.onItemSelectedListener=this
        val aa:ArrayAdapter<*> = ArrayAdapter<Any?>(this@DuaActivity, R.layout.spinner_style,pilBerangkat)
        aa.setDropDownViewResource( R.layout.spinner_style)
        spinBerangkat.adapter = aa
        proses.setOnClickListener{
            val tujuanP = tujuan.text.toString()
            val hargaP = harga.text.toString().toDouble()
            val jumlahP = jumlah.text.toString().toInt()
            val totTiket = hargaP * jumlahP
            val berangkat = spinBerangkat.selectedItem.toString()
            var totalBayar:Int=0
            val tambahan= StringBuffer() //object kotlin
            if(executive.isChecked){
                tambahan.append("\nExecutive Lounge Rp.125000")
                totalBayar += 125000
            }
            if(bagasi.isChecked){
                tambahan.append("\nBagasi Rp.300000")
                totalBayar += 300000
            }
            if(makanan.isChecked){
                tambahan.append("\nMakanan dan Minuman Rp.115000")
                totalBayar += 115000
            }
            tambahan.append("\nTotal Biaya Tambahan : Rp."+ totalBayar)
            val selectedRadio:Int =bayar.checkedRadioButtonId
            var toBayar = totTiket + totalBayar
            rbBayar = findViewById(selectedRadio)
            trans.text = "Detail Pembayaran Tiket "+
                    "\nTujuan : $tujuanP" +
                    "\nHarga Tiket : $hargaP"+
                    "\nJam Berangkat : $berangkat" +
                    "\nBiaya Tambahan : "+tambahan.toString() +
                    "\nJumlah Tiket :$jumlahP"+
                    "\nTotal Biaya Tiket :$totTiket"+
                    "\nMetode Pembayaran :"+rbBayar.text.toString() +
                    "\nTotal Biaya Keseluruhan : $toBayar"
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
      val pilJamBerangkat: String = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this,"Jam berangkat : $pilJamBerangkat", Toast.LENGTH_LONG ).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}