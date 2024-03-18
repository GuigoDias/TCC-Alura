package br.com.CleanFinance.Cartao.CartaoDadosRecords;

import br.com.CleanFinance.Cartao.Cartao;
import br.com.CleanFinance.Compra.Compra;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record DadosCartaoPrepararFatura(
        String numero,
        String nomeCliente,
        String cpfCliente
) {
    public DadosCartaoPrepararFatura(Cartao cartao){
        this(cartao.getNumero(),
                cartao.getCliente().getNome(),
                cartao.getCliente().getCpf());
    }
}