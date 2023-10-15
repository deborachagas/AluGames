package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.GamersDAO
import br.com.alura.alugames.dados.PlanosDAO
import br.com.alura.alugames.modelo.Gamer

fun main(){
    val manager = Banco.getEntityManager()
    val gamerDAO = GamersDAO(manager)
    val planosDAO = PlanosDAO(manager)

//    val gamer = Gamer("Monica", "monica@email.com", "15/03/1995", "moni")
//    gamer.plano = planosDAO.recuperarPeloId(3)
//
//    gamerDAO.adicionar(gamer)

    val listaGamersBanco = gamerDAO.getLista()
    println(listaGamersBanco)

    manager.close()
}