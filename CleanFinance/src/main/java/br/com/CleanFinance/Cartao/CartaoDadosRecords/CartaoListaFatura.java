package br.com.CleanFinance.Cartao.CartaoDadosRecords;

import br.com.CleanFinance.Cartao.Cartao;
import br.com.CleanFinance.Compra.Compra;
import br.com.CleanFinance.Endereco.Endereco;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CartaoListaFatura(@NotNull LocalDateTime data,
                                Endereco estabelecimento,
                                String categoria,
                                BigDecimal valor) {
    public CartaoListaFatura(Compra compra){
        this(compra.getData(),
                compra.getEstabelecimento(),
                compra.getCategoria(),
                compra.getValor());
    }
}
