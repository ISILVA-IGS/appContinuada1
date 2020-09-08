package com.example.continuada1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcular(view: View) {
        txv_Resultado.setTextColor(Color.BLACK)
        val nome = ttp_Nome.text.toString().trim()
        val valorHora =  ttp_horas.text.toString().trim()
        val qtdHora = ttp_valorHora.text.toString().trim()

        if(valorHora.equals("") || qtdHora.equals("")) {
            Toast.makeText(
                this,
                "O valor hora e a quatidade de horas trabahadas são obrigatorias",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        val valorHoraParsed = valorHora.toDouble()
        val qtdHoraParsed = qtdHora.toDouble()
        if(!validarInputs(nome, qtdHoraParsed, valorHoraParsed)) return

        val salario = valorHoraParsed * qtdHoraParsed

        exibirResultado(salario, nome)
    }

    fun validarInputs(nome: String, valorHoraParsed :Double , qtdHoraParsed : Double):Boolean{
        if (nome.length < 3) {
            Toast.makeText(this, "O nome não pode ser vazio e deve ter mais de 3 caracteres", Toast.LENGTH_SHORT).show()
            return false
        }

        if(qtdHoraParsed < 1 || qtdHoraParsed > 720) {
            Toast.makeText(this, "A Quatidade de horas deve ser maior que zero e menor que 720", Toast.LENGTH_SHORT).show()
            return false
        }

        if(qtdHoraParsed < 1) {
            Toast.makeText(this, "O valor hpra deve ser maior que zero", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    fun exibirResultado (salario :Double, nome:String){
        if (salario > 1045 || salario == 1044.0 ) {
            txv_Resultado.text = "$nome seu salario é de: $salario reais e já é igual ou maior que um salario minimo." +
                    "\nParabéns, gaste com sabedoria!!"
            txv_Resultado.setTextColor(Color.CYAN)
        } else {
            txv_Resultado.text = "$nome seu salario é de: $salario reais e não é maior que um salario minimo." +
                    "\nInvista em conhecimento para aumentar seu valor!"
            txv_Resultado.setTextColor(Color.RED)
        }
    }


}