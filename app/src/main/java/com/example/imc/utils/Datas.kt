package com.example.imc.utils

import android.content.Context
import android.graphics.Bitmap
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun convertStringToLocalDate(brazilDate: String) : LocalDate {

    val dateFormatterFromBrazil = DateTimeFormatter
            .ofPattern("dd/MM/yyyy")

    val localDateFormat = LocalDate
            .parse(brazilDate, dateFormatterFromBrazil)

    return localDateFormat

}

fun calcularIdade(dataNascimento: String): Int {

    //Obter a data atual (hoje)
    val hoje = LocalDate.now()

    //Converter a data de nascimento em um Localdate
    val nascimentoArray = dataNascimento.split("-").toTypedArray()

    val nascimento = LocalDate.of(nascimentoArray[0].toInt(), nascimentoArray[1].toInt(), nascimentoArray[2].toInt())

    val idade = Period.between(nascimento, hoje).years

    return idade

}

fun getDataAtualBrasil(): String {

    val dataHoje = LocalDate.now().toString()
    val dataHojeArray = dataHoje.split("-").toTypedArray()
    val dataBrasil = dataHojeArray[2] + "/" + dataHojeArray[1]  + "/" + dataHojeArray[0]

    return dataBrasil

}

fun getImagem(context: Context):Bitmap{
    val arquivo = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)
    val bitmap = convertBase64ToBitmap(arquivo.getString("fotoPerfil","")!!)
    return bitmap

}

