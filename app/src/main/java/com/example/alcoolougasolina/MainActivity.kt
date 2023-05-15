package com.example.alcoolougasolina

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var buttonState: Boolean = false;
    private var _ALCOOL = "Alcool vale a pena"
    private var _GASOLINA = "Gasolina vale a pena"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalc: Button = findViewById(R.id.btCalcular)
        val switch: Switch = findViewById(R.id.swPercentual)
        val alcoolTxt: EditText = findViewById(R.id.precoAlcool)
        val gasolinaTxt: EditText = findViewById(R.id.precoGasolina)
        val resultado: TextView = findViewById(R.id.resultado)

        if(savedInstanceState!=null){
            Log.d("PDM23","Carregando estado")
            alcoolTxt.setText(savedInstanceState.getDouble("alcool").toString())
            gasolinaTxt.setText(savedInstanceState.getDouble("gasolina").toString());
            switch.isChecked=savedInstanceState.getBoolean("estadoBotao")
        }
        buttonState=switch.isChecked


        switch.setOnCheckedChangeListener { _, isChecked ->
            buttonState = isChecked
            Log.d("PDM_teste", "trocou estado para, $buttonState");
        }


        btCalc.setOnClickListener {
            //código do., evento
            val percentual: Double = if (switch.isChecked) 0.75 else 0.70


            try {
                // some code
                val alcool: Double = alcoolTxt.text.toString().toDouble()
                val gasolina: Double = gasolinaTxt.text.toString().toDouble()
                val divisao = alcool / gasolina
                Log.d("PDM23", "percentual testado $percentual")
                Log.d("PDM23", "Divisão entre alcool e gasolina $divisao")
                resultado.text = if (percentual > divisao) _ALCOOL else _GASOLINA
            } catch (e: java.lang.NumberFormatException) {
                // handler
                Log.e("PDM23", "Formato invalido");
            }
            Log.d("PDM23", "No btCalcular, $percentual")
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        try {
            val alcoolTxt: EditText = findViewById(R.id.precoAlcool)
            val gasolinaTxt: EditText = findViewById(R.id.precoGasolina)
            val alcool: Double = alcoolTxt.text.toString().toDouble()
            val gasolina: Double = gasolinaTxt.text.toString().toDouble()
            outState.putDouble("alcool",alcool);
            outState.putDouble("gasolina",gasolina);
            outState.putBoolean("estadoBotao",buttonState)
            Log.d("PDM23","salvou estado")
        }catch (e: java.lang.NumberFormatException) {
            // handler
            Log.e("PDM23", "Formato invalido");
        }
            super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onResume() {
        super.onResume()
        Log.d("PDM23", "No onResume,")
    }

    override fun onStart() {
        super.onStart()
        Log.d("PDM23", "No onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("PDM23", "No onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("PDM23", "No onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("PDM23", "No onResume")
    }

}