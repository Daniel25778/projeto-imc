package com.example.imc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.imc.R
import java.time.LocalDate


class PesoActivity : AppCompatActivity() {
    lateinit var tvData : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peso)

        tvData = findViewById(R.id.textViewData)

        var dataHoje = LocalDate.now().toString()
        var dataHojeArray = dataHoje.split("-").toTypedArray()
        tvData.text = dataHojeArray[2] + "/" + dataHojeArray[0]  + "/" + dataHojeArray[1]

        }
}