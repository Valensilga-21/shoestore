package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // 0->nada; 1->suma; 2->resta; 3->mult; 4->div
    var oper: Int = 0
    var numero1: Double = 0.0
    lateinit var tvNum_1: TextView
    lateinit var tvNum_2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIgual: Button = findViewById(R.id.btnIgual)
        val btnBorrar: Button = findViewById(R.id.btnBorrar)
        tvNum_1 = findViewById(R.id.tvNum_1)
        tvNum_2 = findViewById(R.id.tvNum_2)

        btnIgual.setOnClickListener{
            if (tvNum_2.text.isNotEmpty()) {
                val num2 = tvNum_2.text.toString().toDouble()
                var res = 0.0
                when(oper){
                    1 -> res = numero1 + num2
                    2 -> res = numero1 - num2
                    3 -> res = numero1 * num2
                    4 -> res = numero1 / num2
                }
                tvNum_2.setText(res.toString())
                tvNum_1.setText("")
                numero1 = res // Actualiza numero1 con el resultado para permitir operaciones posteriores
            }
        }

        btnBorrar.setOnClickListener{
            tvNum_1.setText("")
            tvNum_2.setText("")
            oper = 0
            numero1 = 0.0 // Restablece numero1 a cero
        }

    }

    fun clicNumero(view: View){
        val num2 = tvNum_2.text.toString()
        when(view.id){
            R.id.btn0 -> tvNum_2.setText(num2+"0")
            R.id.btn1 -> tvNum_2.setText(num2+"1")
            R.id.btn2 -> tvNum_2.setText(num2+"2")
            R.id.btn3 -> tvNum_2.setText(num2+"3")
            R.id.btn4 -> tvNum_2.setText(num2+"4")
            R.id.btn5 -> tvNum_2.setText(num2+"5")
            R.id.btn6 -> tvNum_2.setText(num2+"6")
            R.id.btn7 -> tvNum_2.setText(num2+"7")
            R.id.btn8 -> tvNum_2.setText(num2+"8")
            R.id.btn9 -> tvNum_2.setText(num2+"9")
            R.id.btnPunto -> tvNum_2.setText(num2+".")
        }
    }

    fun clicOperacion(view: View){
        val num2 = tvNum_2.text.toString()
        numero1 = num2.toDouble()
        tvNum_2.setText("")
        when(view.id){
            R.id.btnMas -> {
                tvNum_1.setText(num2+"+")
                oper = 1
            }
            R.id.btnRest ->{
                tvNum_1.setText(num2+"-")
                oper = 2
            }
            R.id.btnMulti ->{
                tvNum_1.setText(num2+"*")
                oper = 3
            }
            R.id.btnDivi -> {
                tvNum_1.setText(num2+"/")
                oper = 4
            }
        }
    }
}
