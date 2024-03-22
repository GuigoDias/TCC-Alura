package br.com.CleanFinance.Cartao.CartaoDadosRecords;

import br.com.CleanFinance.Compra.Compra;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CartaoListaFatura(@NotNull LocalDateTime data,
                                String estabelecimento,
                                String categoria,
                                BigDecimal valor) {
    public CartaoListaFatura(Compra compra){
        this(compra.getData(),
                compra.getEstabelecimento(),
                compra.getCategoria(),
                compra.getValor());
    }
}
