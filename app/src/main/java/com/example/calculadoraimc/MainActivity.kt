package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoraimc.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            val peso= binding.edtPeso.text.toString().toDouble()
            val altura= binding.edtAltura.text.toString().toDouble()
            val result= peso / (altura*altura)
            val df= DecimalFormat("#.##")
            val imc= df.format(result).toString()

            if(result<18.5)
                binding.txtResultado.text= "Você está abaixo do peso, seu IMC é de $imc"


            else if(result>18.5 && result<25)
                binding.txtResultado.text= "Você está com o peso normal, seu IMC é de $imc"


            else
                binding.txtResultado.text= "Você está acima do peso, seu IMC é de $imc"

        }
    }
}