package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Periodo
import br.com.alura.alugames.modelo.PlanoAssinatura
import br.com.alura.alugames.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogos = consumo.buscaJogos()
//    val jogoApi = consumo.buscaJogo("151")
//    println(listaGamers)
//    println(jogoApi)

//    val gamerCaroline = listaGamers.get(3)
//    val jogoResidentVillage = listaJogos.get(10)
    val jogo2 = listaJogos.get(13)
    val jogo3 = listaJogos.get(2)
    val jogo4 = listaJogos.get(5)
    val jogo5 = listaJogos.get(7)
//
//    println(gamerCaroline)
//    println(jogoResidentVillage)
//
//    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo4 = Periodo(LocalDate.now().plusDays(-30), LocalDate.now().plusDays(-25))
    val periodo5 = Periodo(LocalDate.now(), LocalDate.now().plusDays(4))
//
//    gamerCaroline.alugaJogo(jogoResidentVillage, periodo1)
//    gamerCaroline.alugaJogo(jogo2, periodo2)
//    gamerCaroline.alugaJogo(jogo3, periodo3)
//    gamerCaroline.alugaJogo(jogo4, periodo4)
//
//    println(gamerCaroline.jogosAlugados)
//
//    println("Alugueis mes 10")
//    println(gamerCaroline.alugueisMes(10))
//
    val gamerCamila = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)
//    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
    gamerCamila.alugaJogo(jogo2, periodo2)
    gamerCamila.alugaJogo(jogo3, periodo3)
    gamerCamila.alugaJogo(jogo4, periodo4)
    gamerCamila.alugaJogo(jogo5, periodo5)
    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
    println(gamerCamila)
//
//    gamerCamila.alugaJogo(jogoResidentVillage, periodo1)
//    println(gamerCamila.jogosAlugados)
//
//    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogo2, 10)
//
//    gamerCaroline.recomendarJogo(jogoResidentVillage, 8)
//    gamerCaroline.recomendarJogo(jogo2, 9)
//
    println("Recomendações Camila")
    println(gamerCamila.jogosRecomendados)
//    println("Recomendações Caroline")
//    println(gamerCaroline.jogosRecomendados)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogos.get(10)
    val jogoSpider = listaJogos.get(13)
    val jogoTheLastOfUs = listaJogos.get(2)
    val jogoDandara = listaJogos.get(5)
    val jogoAssassins = listaJogos.get(4)
    val jogoCyber = listaJogos.get(6)
    val jogoGod = listaJogos.get(7)
    val jogoSkyrim = listaJogos.get(18)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)

    println(gamerCamila)
    println(gamerCamila.jogosRecomendados)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)

    println(serializacao)

    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)


}