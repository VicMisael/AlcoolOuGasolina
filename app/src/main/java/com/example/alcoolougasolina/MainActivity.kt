package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var buttonState:Boolean = false;
    val ALCOOL="Alcool vale a pena"
    val GASOLINA="Gasolina vale a pena"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalc: Button = findViewById(R.id.btCalcular)
        val switch: Switch = findViewById(R.id.swPercentual)
        val alcoolTxt:EditText = findViewById(R.id.precoAlcool)
        val gasolinaTxt:EditText = findViewById(R.id.precoGasolina)
        val resultado:TextView = findViewById(R.id.resultado)
        switch.setOnCheckedChangeListener{ _,isChecked ->
            buttonState=isChecked
            Log.d("PDM_teste","trocou estado para, $buttonState");
        }


        btCalc.setOnClickListener {
            //código do., evento
            val percentual: Double = if (buttonState) 0.75 else 0.70


            try {
                // some code
                val alcool: Double = alcoolTxt.text.toString().toDouble()
                val gasolina: Double = gasolinaTxt.text.toString().toDouble()
                val divisao = alcool / gasolina
                Log.d("PDM23","percentual testado $percentual")
                Log.d("PDM23","Divisão entre alcool e gasolina $divisao")
                resultado.text = if (percentual > divisao) ALCOOL else GASOLINA
            } catch (e: java.lang.NumberFormatException) {
                // handler
                Log.e("PDM23", "Formato invalido");
            }
            Log.d("PDM23", "No btCalcular, $percentual")
        }
    }
override fun onResume(){
    super.onResume()
    Log.d("PDM23","No onResume,")
}
override fun onStart(){
    super.onStart()
    Log.d("PDM23","No onResume")
}
override fun onPause(){
    super.onPause()
    Log.d("PDM23","No onResume")
}
override fun onStop(){
    super.onStop()
    Log.d("PDM23","No onResume")
}
override fun onDestroy(){
    super.onDestroy()
    Log.d("PDM23","No onResume")
}
}