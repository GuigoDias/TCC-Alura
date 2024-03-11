package br.com.CleanFinance.Cartao;

import br.com.CleanFinance.Cliente.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCartao(@NotNull double limite,
                                  @NotBlank
                                  Cliente cliente) {
}
