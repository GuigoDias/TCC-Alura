package br.com.CleanFinance.Cartao.CartaoDadosRecords;

import br.com.CleanFinance.Cliente.Cliente;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

public record DadosCadastroCartao(@NotNull
                                  @Positive
                                  @NumberFormat(style = NumberFormat.Style.CURRENCY)
                                  BigDecimal limite,
                                  @NotNull
                                  Cliente cliente) {
}
