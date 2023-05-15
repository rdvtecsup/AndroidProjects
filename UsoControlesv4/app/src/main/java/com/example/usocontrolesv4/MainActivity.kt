package com.example.usocontrolesv4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnOk = findViewById<Button>(R.id.btnOk)
        var txtUsuario = findViewById<EditText>(R.id.txtusuario)
        var txtClave = findViewById<EditText>(R.id.txtclave)
        var tglOnOff = findViewById<ToggleButton>(R.id.tglOnOff)
        var lblver = findViewById<TextView>(R.id.lblver)
        btnOk.setOnClickListener(){
            var usuario = txtUsuario.text.toString()
            var clave = txtClave.text.toString()

            if (tglOnOff.isChecked){
                lblver.setText(clave)
            }else{
                lblver.setText(usuario + " no tiene permisos para ver la clave")
            }
        }
    }
}