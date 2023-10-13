package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer

fun main() {
    val gamer1 = Gamer("Debora", "debora@email.com")

    gamer1.let {
        it.dataNascimento = "01/01/2000"
        it.usuario = "darcbr"
    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "teste"
    println(gamer1)

    val gamer2 = Gamer(" ", "debora@email.com", "01/01/2000", "darcbr")

    println(gamer2)
}