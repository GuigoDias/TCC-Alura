package br.com.CleanFinance.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(@NotBlank
                            @Pattern(regexp = "\\d{8}")
                            String cep,
                            @NotBlank
                            String logradouro,
                            String numero,
                            @NotBlank
                            String bairro,
                            String complemento,
                            @NotBlank
                            String localidade,
                            @NotBlank
                            String uf) {
}