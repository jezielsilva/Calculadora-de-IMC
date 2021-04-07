package com.example.imcapplication


import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){
        alturaEDT?.doAfterTextChanged{text ->
           // Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
       pesoEDT?.doOnTextChanged { text, _, _, _ ->
          // imc?.text = text
       }

        calcularBTN.setOnClickListener{
            calculatorImC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
    }


    private fun calculatorImC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if(peso != null && altura != null){
            val imc = peso/ (altura * altura)
            imcTXT.text = "Seu IMC é de ${imc}".format(imc)
        }
    }
}


