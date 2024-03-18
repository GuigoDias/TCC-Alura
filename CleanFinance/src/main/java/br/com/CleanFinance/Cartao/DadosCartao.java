package br.com.CleanFinance.Cartao;

import java.math.BigDecimal;

public record DadosCartao(
        String numero,
        BigDecimal limite,
        String validade,
        String nomeCliente,
        String cpfCliente
) {
    public DadosCartao(Cartao cartao){
        this(cartao.getNumero(),
                cartao.getLimite(),
                cartao.getValidade(),
                cartao.getCliente().getNome(),
                cartao.getCliente().getCpf());
    }
}