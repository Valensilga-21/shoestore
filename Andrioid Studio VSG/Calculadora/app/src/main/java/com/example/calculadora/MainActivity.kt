package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val btnVaciar: Button = findViewById(R.id.btnVaciar)
        tvNum_1 = findViewById(R.id.tvNum_1)
        tvNum_2 = findViewById(R.id.tvNum_2)

        btnIgual.setOnClickListener{
            if (tvNum_2.text.isNotEmpty()) {
                val num2Text = tvNum_2.text.toString()
                val num2 = if (num2Text != ".") num2Text.toDouble() else 0.0
                var res = 0.0

        when(oper){
                    1 -> {
                        if (num2 != 0.0) {
                            res = numero1 + num2
                        } else {
                            tvNum_2.setText("Operacion erronea")
                            return@setOnClickListener
                        }
                    }
                    2 -> {
                        if (num2 != 0.0) {
                            res = numero1 - num2
                        } else {
                            tvNum_2.setText("Operacion erronea")
                            return@setOnClickListener
                        }
                    }
                    3 -> {
                        if (num2 != 0.0) {
                            res = numero1 * num2
                        } else {
                            tvNum_2.setText("Operacion erronea")
                            return@setOnClickListener
                        }
                    }
                    4 -> {
                        if (num2 != 0.0) {
                            res = numero1 / num2
                        } else {
                            tvNum_2.setText("Operacion erronea")
                            return@setOnClickListener
                        }
                    }
                }
                tvNum_2.setText(res.toString())
                tvNum_1.setText("")
                numero1 = res
            }
        }

        btnVaciar.setOnClickListener{
            tvNum_1.setText("")
            tvNum_2.setText("")
            oper = 0
            numero1 = 0.0
        }

    }

    fun clickNumero(view: View){
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

    fun clickOperacion(view: View){
        val num2 = tvNum_2.text.toString()
        if (num2.isNotEmpty()) {
            numero1 = num2.toDouble()
        } else {
            numero1 = 0.0 // Si no hay ningún número, asigna 0.0 a numero1
        }
        tvNum_2.setText("")
        when(view.id){
            R.id.btnSumar -> {
                if (num2.isNotEmpty()) {
                    tvNum_1.setText(num2+"+")
                }
                oper = 1
            }
            R.id.btnRestar ->{
                if (num2.isNotEmpty()) {
                    tvNum_1.setText(num2+"-")
                }
                oper = 2
            }
            R.id.btnMultiplicar ->{
                if (num2.isNotEmpty()) {
                    tvNum_1.setText(num2+"*")
                }
                oper = 3
            }
            R.id.btnDividir -> {
                if (num2.isNotEmpty()) {
                    tvNum_1.setText(num2+"/")
                }
                oper = 4
            }
        }
    }


}