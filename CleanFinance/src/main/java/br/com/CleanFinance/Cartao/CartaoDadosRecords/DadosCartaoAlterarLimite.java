package br.com.CleanFinance.Cartao.CartaoDadosRecords;

import br.com.CleanFinance.Cartao.Cartao;
import br.com.CleanFinance.Cliente.Cliente;

import java.math.BigDecimal;

public record DadosCartaoAlterarLimite(
        String numero,
        BigDecimal limite,
        String validade,
        Cliente cliente
) {
    public DadosCartaoAlterarLimite(Cartao cartao){
        this(cartao.getNumero(),
                cartao.getLimite(),
                cartao.getValidade(),
                cartao.getCliente());
    }
}