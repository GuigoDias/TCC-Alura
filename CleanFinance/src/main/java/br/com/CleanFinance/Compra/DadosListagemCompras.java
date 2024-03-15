package br.com.CleanFinance.Compra;

import br.com.CleanFinance.Endereco.Endereco;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DadosListagemCompras(
        BigDecimal valor,
        LocalDateTime data,
        Endereco estabelecimento,
        String categoria
) {
    public DadosListagemCompras(Compra compra) {
        this(compra.getValor(),compra.getData(),compra.getEstabelecimento(),compra.getCategoria());
    }
}
