package edu.iest.primerexamenparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var peliculaRecibida = intent.getStringExtra("titulo")
        var horario = intent.getStringExtra("horario")

        var tvPelicula = findViewById<TextView>(R.id.tvPelicula)
        var tvHorario = findViewById<TextView>(R.id.tvHorario)

        tvPelicula.text = peliculaRecibida
        tvHorario.text = horario
    }
}