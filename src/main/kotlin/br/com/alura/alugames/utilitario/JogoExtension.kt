package br.com.alura.alugames.utilitario

import br.com.alura.alugames.dados.JogoEntity
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.modelo.InfoJogoJson

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(
        this.titulo,
        this.capa,
        this.preco,
        this.descricao
    )
}

fun Jogo.toEntity(): JogoEntity {
    return JogoEntity(this.id, this.titulo, this.capa, this.preco, this.descricao)
}

fun JogoEntity.toModel(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao, this.id)
}