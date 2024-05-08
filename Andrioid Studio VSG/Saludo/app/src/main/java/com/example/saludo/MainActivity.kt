package com.example.saludo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //DEFINICION DE LOS OBJETOS
        var btnIngresar: Button
        var txtNombre: TextView

        //ASIGNACION DEL VALOR
        //Variable R, se denomina a los Resorce (recurcos) que se encuentran en la carpeta Res
        btnIngresar=findViewById((R.id.btnIngresar))
        txtNombre=findViewById((R.id.txtNombre))

        //CONFIGURAR  LA ACCION AL PRESIONAR EL BOTON INGRESAR
        btnIngresar.setOnClickListener{
            var nombre=txtNombre.text
            //se utiliza el mensaje Toast para mostrar
            //el saludo
            Toast.makeText(applicationContext,//contexto)
                "Hola ${nombre}" , //texto a mostrar
                Toast.LENGTH_LONG //duracion del mensaje
            ).show()
        }

    }
}