package com.example.pasovariablesactividadesv4



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AdapterView.OnItemClickListener
import kotlinx.android.synthetic.main.activity_profesores.*

class profesores : AppCompatActivity() {
    var datosactividad01:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profesores)

        val values = arrayOf(
            "Prof. Cálculo",
            "Prof. Inglés",
            "Prof. Desarrollo de software",
            "Prof. Base de datos"
        )
        val adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, android.R.id.text1,
            values
        )
        listadeprofesores
        listadeprofesores.adapter = adapter
        listadeprofesores.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val itemPosition = position
                val itemValue= listadeprofesores.getItemAtPosition(position) as String
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