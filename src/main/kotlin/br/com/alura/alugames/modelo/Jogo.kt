package br.com.alura.alugames.modelo

import com.google.gson.annotations.Expose
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

data class Jogo(@Expose val titulo:String,
                @Expose val capa:String
): Recomendavel {
    var preco:Double = 0.0
    var descricao:String? = null
    var id = 0
    private val listaNotas = mutableListOf<Int>()

    override val media: Double
        get() = listaNotas.average()
    constructor(titulo: String, capa: String, preco: Double, descricao: String?, id: Int = 0):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
        this.id = id
    }

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    override fun toString(): String {

        return "Jogo: \n" +
                "Id: $id \n" +
                "Titulo: $titulo \n" +
                "Preço: $preco \n"+
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "Reputação: ${this.mediaFormatada()} \n"
    }
}