package br.com.CleanFinance.Compra.CompraDadosRecords;

import br.com.CleanFinance.Cartao.Cartao;
import br.com.CleanFinance.Endereco.Endereco;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

public record DadosCadastroCompra(
        @NotNull
        Cartao cartao,
        @NotNull
        @Positive
        @NumberFormat(style = NumberFormat.Style.CURRENCY)
        BigDecimal valor,
        @NotNull
        String categoria,
        @NotNull
        @Size(min = 5,message = "Mínimo 5 caracteres")
        Endereco estabelecimento
) {
}
