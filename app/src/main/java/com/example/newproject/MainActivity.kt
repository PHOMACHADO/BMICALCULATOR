package com.example.newproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalcular: Button =   findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edtTextPeso)
        val edtAltura: EditText = findViewById(R.id.edtTextAltura)
        val tvResult : TextView = findViewById(R.id.txtMsg)

        btnCalcular.setOnClickListener {

            // recuperei do usuario
            val message: String = edtPeso.text.toString()

            // aqui eu mostro uma nova mensagem no TextView
            tvResult.text = message

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()

                val alturaFinal: Float = altura * altura
                val result: Float = peso / alturaFinal


//             aqui eu mostro uma nova mensagem no TextView
                tvResult.text = result.toString()

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }

                startActivity(intent)

            }else {
                Toast.makeText(this, "Make sure to fill all the required gaps", Toast.LENGTH_LONG).show()
            }

        }
    }
}