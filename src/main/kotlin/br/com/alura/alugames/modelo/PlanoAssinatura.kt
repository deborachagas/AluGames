package br.com.alura.alugames.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val percentualDescontoReputacao: Double,
    id: Int = 0
): Plano(tipo, id) {

    override fun obtervalor(aluguel: Aluguel): Double {
        val totalJogosMes = aluguel.gamer.alugueisMes(aluguel.periodo.dataInicial.monthValue).size+1
        return if (totalJogosMes <= jogosIncluidos) {
            0.0
        } else {
            var valorOriginal = super.obtervalor(aluguel)

            if(aluguel.gamer.media > 8) {
                valorOriginal -= valorOriginal * percentualDescontoReputacao
            }
            valorOriginal
        }
    }

    override fun toString(): String {
        return "Plano Assinatura\n" +
                "Tipo: $tipo\n" +
                "Id: $id\n" +
                "Mensalidade: $mensalidade\n" +
                "Jogos Incluidos: $jogosIncluidos\n" +
                "Percentual Desconto Reputacao: $percentualDescontoReputacao\n"
    }
}