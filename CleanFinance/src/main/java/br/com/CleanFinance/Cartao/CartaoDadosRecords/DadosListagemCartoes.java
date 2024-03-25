package br.com.CleanFinance.Cartao.CartaoDadosRecords;

import br.com.CleanFinance.Cartao.Cartao;
import br.com.CleanFinance.Cliente.Cliente;

import java.math.BigDecimal;

public record DadosListagemCartoes (String numero,
                                       String cliente,
                                       BigDecimal limite,
                                    String cvv,
                                    String validade){
    public DadosListagemCartoes(Cartao cartao){
        this(cartao.getNumero(),cartao.getCliente().getNome(),cartao.getLimite(),cartao.getCvv(),cartao.getValidade());
    }
}
