package br.com.CleanFinance.Compra.CompraDadosRecords;

import br.com.CleanFinance.Cartao.Cartao;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.NumberFormat;
import java.math.BigDecimal;

public record DadosCadastroCompra(
        @NotNull
        Cartao cartao_id,
        @NotNull
        @Positive
        @NumberFormat(style = NumberFormat.Style.CURRENCY)
        BigDecimal valor,
        @NotNull
        String categoria,
        @NotBlank
        String estabelecimento
) {
}