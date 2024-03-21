package br.com.CleanFinance.Cartao.CartaoDadosRecords;

import br.com.CleanFinance.Cartao.Cartao;

import java.math.BigDecimal;

public record DadosListagemCartoes (String numero,
                                       Long clienteId,
                                       BigDecimal limite,
                                    String cvv,
                                    String validade){
    public DadosListagemCartoes(Cartao cartao){
        this(cartao.getNumero(),cartao.getClienteId(),cartao.getLimite(),cartao.getCvv(),cartao.getValidade());
    }
}
