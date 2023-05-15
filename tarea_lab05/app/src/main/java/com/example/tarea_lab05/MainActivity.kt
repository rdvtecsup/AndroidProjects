package com.example.tarea_lab05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editLabos = findViewById<EditText>(R.id.editLabos)
        var editPC1 = findViewById<EditText>(R.id.editPC1)
        var editPC2 = findViewById<EditText>(R.id.editPC2)
        var editPC3 = findViewById<EditText>(R.id.editPC3)
        var editPC4 = findViewById<EditText>(R.id.editPC4)

        var txtResult = findViewById<TextView>(R.id.txtResult)

        var imgResultAprobado = findViewById<ImageView>(R.id.imgResultAprobado)
        var imgResultDesaprobado = findViewById<ImageView>(R.id.imgResultDesaprobado)

        var btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener {

            var lab = editLabos.text.toString().toDouble()
            var p1 = editPC1.text.toString().toDouble()
            var p2 = editPC2.text.toString().toDouble()
            var p3 = editPC3.text.toString().toDouble()
            var p4 = editPC4.text.toString().toDouble()

            var minNota = minOf(p1, p2, p3, p4)
            var promedioPracticas = ((p1 + p2 + p3 + p4) - minNota) / 3.0

            var promedioLaboratorios = lab * 0.7
            var promedioFinal = (promedioLaboratorios) + (promedioPracticas * 0.3)

            txtResult.text = "Promedio final: ${String.format("%.2f", promedioFinal)}"

            if (promedioFinal >= 13) {
                imgResultAprobado.visibility = View.VISIBLE
                imgResultDesaprobado.visibility = View.INVISIBLE

            } else {
                imgResultAprobado.visibility = View.INVISIBLE
                imgResultDesaprobado.visibility = View.VISIBLE
            }
        }
    }
}

