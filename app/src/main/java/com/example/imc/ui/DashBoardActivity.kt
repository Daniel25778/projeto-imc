package com.example.imc.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.imc.R
import com.example.imc.repository.PesagemRepository
import com.example.imc.utils.calcularIdade
import com.example.imc.utils.convertBase64ToBitmap
import java.time.LocalDate

class DashBoardActivity : AppCompatActivity() {

   lateinit var tvNome : TextView
    lateinit var tvProfissao : TextView
    lateinit var tvImc : TextView
    lateinit var tvNcd : TextView
    lateinit var tvPeso : TextView
    lateinit var tvIdade : TextView
    lateinit var tvAltura : TextView
    lateinit var tvPerfil : ImageView
    lateinit var cardHistorico : CardView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        tvNome = findViewById(R.id.dash_nome)
        tvProfissao = findViewById(R.id.dash_profissao)
        tvImc = findViewById(R.id.dash_imc)
        tvNcd = findViewById(R.id.dash_ncd)
        tvPeso = findViewById(R.id.dash_peso)
        tvIdade = findViewById(R.id.dash_idade)
        tvAltura = findViewById(R.id.dash_altura)
        tvPerfil = findViewById(R.id.iv_dash_foto_perfil)
        cardHistorico = findViewById(R.id.cardView_historico)



        carregarDashboard()

        val cardViewDashPeso = findViewById<CardView>(R.id.cardViewDashPeso)

        cardViewDashPeso.setOnClickListener {
            val peso = Intent(this, PesoActivity::class.java)
            startActivity(peso)
        }

        cardHistorico.setOnClickListener{

            val intent = Intent(this, HistoricoActivity::class.java)
            startActivity(intent)
        }


    }

    private fun  carregarDashboard() {

        val arquivo = getSharedPreferences("usuario", Context.MODE_PRIVATE)

        tvNome.text = arquivo.getString("nome", "")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()

        tvIdade.text = calcularIdade(arquivo.getString("dataNascimento", "")!!).toString()

        val bitmap = convertBase64ToBitmap(arquivo.getString("fotoPerfil","")!!)
        tvPerfil.setImageBitmap(bitmap)


    }


}