package br.com.CleanFinance.Cartao.CartaoDadosRecords;

import br.com.CleanFinance.Cartao.Cartao;

import java.math.BigDecimal;

public record DadosCartaoAlterarLimite(
        String numero,
        BigDecimal limite,
        String validade,
        Long clienteId
) {
    public DadosCartaoAlterarLimite(Cartao cartao){
        this(cartao.getNumero(),
                cartao.getLimite(),
                cartao.getValidade(),
                cartao.getClienteId());
    }
}