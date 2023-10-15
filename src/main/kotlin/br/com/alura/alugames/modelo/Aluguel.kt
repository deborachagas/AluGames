package br.com.alura.alugames.modelo

class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo) {

    val valorDoAluguel: Double = gamer.plano.obtervalor(this)
    var id:Int = 0

    override fun toString(): String {
        return "Aluguel \n" +
                "Id: $id \n" +
                "Jogo: ${jogo.titulo} \n" +
                "Gamer: ${gamer.nome} \n" +
                "Valor $valorDoAluguel"
    }
}