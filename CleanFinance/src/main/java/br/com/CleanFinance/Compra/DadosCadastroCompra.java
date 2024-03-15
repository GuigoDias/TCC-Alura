package br.com.CleanFinance.Compra;

import br.com.CleanFinance.Cartao.Cartao;
import br.com.CleanFinance.Endereco.Endereco;

import java.math.BigDecimal;

public record DadosCadastroCompra(
        Cartao cartao,
        BigDecimal valor,
        String categoria,
        Endereco estabelecimento
) {
}
