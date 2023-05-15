package com.example.pasovariablesactividadesv4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class cerrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cerrar)

        val btnSi = findViewById<Button>(R.id.btn_si)
        val btnNo = findViewById<Button>(R.id.btn_no)

        btnSi.setOnClickListener(View.OnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("¿Está seguro de que desea cerrar la aplicación?")
                .setCancelable(false)
                .setPositiveButton("Sí") { dialog, id ->
                    // cierra la aplicación
                    finishAffinity()
                }
                .setNegativeButton("No") { dialog, id ->
                    dialog.cancel()
                }
            val alert = builder.create()
            alert.show()
        })

        btnNo.setOnClickListener(View.OnClickListener {
            // vuelve a la actividad principal
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        })
    }
}