package com.example.newproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


       val tvResult = findViewById<TextView>(R.id.textView_Result)
       val tvClassificacao = findViewById<TextView>(R.id.textView_Classificacao)

      val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        tvResult.text = result.toString()

//        IMC - CLASSIFICAÇÃO:
//
//        Menor que 18.5 - Abaixo do peso ;
//        Entre 18.5 e 24.9 - Peso normal ;
//        Entre 25.0 e 29.9 - Pré-obesidade ;
//        Entre 30.0 e 34.9 - Obesidade Grau 1 ;
//        Entre 35.0 e 39.9 - Obesidade Grau 2 ;
//        Acima de 40 - Obesidade Grau 3

        val classificacao = if(result < 18.5f){
            "LOWER THAN EXPECTED"
            // another way to have it on our code which simplifies it
        }else if (result in 18.5f..24.9f) {
            "NORMAL"
        }else if (result in 25f..29.9f) {
            "ABOVE NORMAL WEIGHT"
        }else if (result in 30f..34.9f){
            "OBESITY FIRST LEVEL"
        }else if (result in 35f..39.9f){
            "OBESITY SECOND LEVEL"
        }else {
            "OBESITY THIRD LEVEL"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        finish()
        return super.onOptionsItemSelected(item)
    }

}