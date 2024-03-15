package br.com.CleanFinance.Cartao;

import br.com.CleanFinance.Cliente.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroCartao(@NotNull BigDecimal limite,
                                  @NotBlank
                                  Cliente cliente) {
}
