package br.com.CleanFinance.Cartao.CartaoDadosRecords;

import br.com.CleanFinance.Cartao.Cartao;
import br.com.CleanFinance.Cliente.Cliente;

public record DadosCartaoPrepararFatura(
        String numero,
        String cliente
) {
    public DadosCartaoPrepararFatura(Cartao cartao){
        this(cartao.getNumero(),
                cartao.getCliente().getNome());
    }
}