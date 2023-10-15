package br.com.alura.alugames.modelo

import java.text.DecimalFormat

interface Recomendavel {
    val media: Double
    fun mediaFormatada():String {
        val df = DecimalFormat("#.##")
        return df.format(this.media)
    }
    fun recomendar(nota: Int)
}