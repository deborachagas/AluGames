package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi
import transformarEmIdade
import java.util.Scanner


fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro concluído com sucesso")
    println(gamer)
    println("Idade do gamer: " + gamer.dataNascimento?.transformarEmIdade())

    do {
        println("Digite um código de jogo para buscar: ")
        val busca = leitura.nextLine()

        var meuJogo: Jogo? = null
        val buscaApi = ConsumoApi()

        val resultado = runCatching {
            var meuInfoJogo = buscaApi.buscaJogo(busca)
            meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
        }

        resultado.onFailure {
            println("br.com.alura.alugames.modelo.Jogo inexistente. Tente outro.")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            var opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Insira a descrição personalizada")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }
            gamer.jogosBuscados.add(meuJogo)
        }
        println("Deseja buscar um novo jogo? S/N")
        val resposta = leitura.nextLine()

    } while (resposta.equals("s", true))

    println("Jogos buscados: ")
    println(gamer.jogosBuscados)

    println("Jogos ordenados por título")
    gamer.jogosBuscados.sortBy { it?.titulo }
    gamer.jogosBuscados.forEach {
        println("Titulo: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }
    println("Jogos filtrados")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? s/n")
    val opcao = leitura.nextLine()
    if (opcao.equals("s", true)){
        println("Informe a posição do jogo que deseja excluir: ")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("Lista atualizada: ")
    gamer.jogosBuscados.forEach {
        println("Titulo: " + it?.titulo)
    }

    println("Busca finalizada com sucesso.")
}