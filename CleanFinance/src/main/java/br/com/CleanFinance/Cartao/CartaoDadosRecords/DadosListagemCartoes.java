package br.com.CleanFinance.Cartao.CartaoDadosRecords;

import br.com.CleanFinance.Cartao.Cartao;

import java.math.BigDecimal;

public record DadosListagemCartoes (String numero,
                                       String clienteNome,
                                       BigDecimal limite,
                                    String validade){
    public DadosListagemCartoes(Cartao cartao){
        this(cartao.getNumero(),cartao.getCliente().getNome(),cartao.getLimite(),cartao.getValidade());
    }
}
