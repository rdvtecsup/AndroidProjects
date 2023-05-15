package com.example.pasovariablesactividadesv4


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AdapterView.OnItemClickListener
import kotlinx.android.synthetic.main.activity_aplicaciones.*

class aplicaciones : AppCompatActivity() {
    var datosactividad01:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aplicaciones)

        val values = arrayOf(
            "WhatsApp",
            "Discord",
            "Twitch",
            "Instagram",
            "Facebook",
            "Telegram"
        )
        val adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, android.R.id.text1,
            values
        )
        listadeapps.adapter = adapter
        listadeapps.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val itemPosition = position
                val itemValue= listadeapps.getItemAtPosition(position) as String
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("parametro", itemValue)
                intent.putExtra("datosactividad01", datosactividad01)
                this.finish()
                startActivity(intent)
            }
        val bundle :Bundle ?=intent.extras
        if(bundle!=null){
            datosactividad01 = bundle.getString("seleccionados").toString()
        }
    }
}