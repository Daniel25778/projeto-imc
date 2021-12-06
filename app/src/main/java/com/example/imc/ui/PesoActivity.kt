package com.example.imc.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.cardview.widget.CardView
import com.example.imc.R
import com.example.imc.utils.convertBase64ToBitmap
import com.example.imc.utils.getDataAtualBrasil
import com.example.imc.utils.getImagem
import java.time.LocalDate


class PesoActivity : AppCompatActivity() {
    lateinit var tvData : TextView
    lateinit var spinner: Spinner
    lateinit var novoPeso: EditText
    lateinit var btnRegistrarPeso : Button
    private lateinit var ivPerfilPeso : ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peso)

        ivPerfilPeso = findViewById(R.id.imageViewPerfilPeso)
        tvData = findViewById(R.id.textViewData)
        btnRegistrarPeso = findViewById(R.id.button)
        spinner = findViewById(R.id.spinnerNivelAtividade)
        novoPeso = findViewById(R.id.editTextPesoAtual)

        tvData.text = getDataAtualBrasil()
      

        btnRegistrarPeso.setOnClickListener {

            val arquivo = getSharedPreferences("usuario", Context.MODE_PRIVATE)
            val pesagem = arquivo.getString("pesagem", "")
            val dataPesagem = arquivo.getString("data_pesagem", "")
            val nivel = arquivo.getString("nivel", "")


            val editor = arquivo.edit()
            editor.putString("pesagem", "$pesagem;${novoPeso.text.toString()}")
            editor.putString("data_pesagem", "$dataPesagem;${LocalDate.now().toString()}")
            editor.putString("nivel", "$nivel;${spinner.selectedItemPosition.toString()}")
            editor.apply()


            Toast.makeText(this, "Peso Registrado com sucesso!", Toast.LENGTH_SHORT).show()
            finish()

           }

        }
}