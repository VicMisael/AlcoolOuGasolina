package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    var buttonState:Boolean = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PDM23","No onCreate, $percentual")

        val btCalc: Button = findViewById(R.id.btCalcular)
        val switch: Switch = findViewById(R.id.swPercentual);
        switch.setOnCheckedChangeListener{ _,isChecked ->
            buttonState=isChecked
            Log.d("PDM_teste","trocou estado para, $buttonState");
        }


        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            percentual=0.75
            Log.d("PDM23","No btCalcular, $percentual")
        })
    }
override fun onResume(){
    super.onResume()
    Log.d("PDM23","No onResume, $percentual")
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