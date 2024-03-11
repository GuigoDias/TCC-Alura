package br.com.CleanFinance.Cartao;

import br.com.CleanFinance.Cliente.Cliente;

import java.time.LocalDate;

public record DadosListagemCartoes (int numero,
                                       Cliente cliente,
                                       double limite,
                                    LocalDate validade){
    public DadosListagemCartoes(Cartao cartao){
        this(cartao.getNumero(),cartao.getCliente(),cartao.getLimite(),cartao.getValidade());
    }
}
