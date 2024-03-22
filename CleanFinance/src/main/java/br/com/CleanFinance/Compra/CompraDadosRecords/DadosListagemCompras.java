package br.com.CleanFinance.Compra.CompraDadosRecords;

import br.com.CleanFinance.Compra.Compra;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DadosListagemCompras(
        BigDecimal valor,
        LocalDateTime data,
        String estabelecimento,
        String categoria
) {
    public DadosListagemCompras(Compra compra) {
        this(compra.getValor(),compra.getData(),compra.getEstabelecimento(),compra.getCategoria());
    }
}
