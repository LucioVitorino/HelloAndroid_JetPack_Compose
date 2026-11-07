package ao.co.isptec.aplm.helloandroid


data class PalavraBundle(val palavras: List<String>) {
    val contar = palavras.size
    val comprimentoMedio = if (palavras.isEmpty())
                                0.0;
                            else
                                palavras.map{it.length}.average();
    val palavraMaisLonga = palavras.maxByOrNull { it.length } ?: "Não disponível.";
}

fun gerarResumo(bundle: PalavraBundle) : String{
    val palavrasLongas = bundle.palavras.filter { it.length > 4}
    return "Palavras ${bundle.contar}, comprimento médio : ${bundle.comprimentoMedio}," +
            " palavras longas: ${palavrasLongas.joinToString("; ")}"
}