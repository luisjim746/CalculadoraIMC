package com.example.miprimerproyecto

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

        val tvresult = findViewById<TextView>(R.id.textview_result)
        val tvclasificacion = findViewById<TextView>(R.id.textview_clasificacion)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvresult.text = result.toString()


        val clasificacion = if(result < 18.5f){
            "BAJO PESO"
        }else if(result in 18.5f..24.9f){
            "NORMAL"
        }else if(result in 25f..29.9f){
            "SOBREPESO"
        }else if(result in 30f..39.9f){
            "OBESIDAD"
        }else{
            "OBESIDAD GRAVE"
        }

        tvclasificacion.text = getString(R.string.message_clasificacion, clasificacion)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}