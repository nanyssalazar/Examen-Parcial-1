package edu.iest.primerexamenparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private var cambioIcono: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val adaptador_sp1 = ArrayAdapter.createFromResource(this,R.array.horarios, android.R.layout.simple_spinner_item)
        adaptador_sp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        var spHorarios = findViewById<Spinner>(R.id.spHorarios)
        var bnComprarBoletos = findViewById<Button>(R.id.bnComprarBoletos)
        var ivMinion = findViewById<ImageView>(R.id.ivMinion)
        var tvPiePagina = findViewById<TextView>(R.id.tvPiePagina)
        var tvTitulo = findViewById<TextView>(R.id.tvTitulo)

        bnComprarBoletos.setOnClickListener{
            var spText = spHorarios.selectedItem.toString()
            if(spText == "15:00 SUB" || spText == "17:00 ESP" || spText =="19:00 ESP") {
                Toast.makeText(this,"Lo sentimos se han agotado las entradas",
                    Toast.LENGTH_LONG).show()
            } else {
                val i = Intent(this, MainActivity2::class.java)
                i.putExtra("titulo",tvTitulo.text.toString())
                i.putExtra("horario",spText)
                startActivity(i)
            }
        }

        ivMinion.setOnClickListener{
            var arregloImagenes = arrayOf<Int>(R.drawable.minionsposter2, R.drawable.minionsposter)
            if (cambioIcono) {
                ivMinion.setImageResource(arregloImagenes[0])
            } else {
                ivMinion.setImageResource(arregloImagenes[1])
            }
            cambioIcono = !cambioIcono
        }

        tvPiePagina.setOnClickListener{
            finish()
        }
    }
}