package br.com.CleanFinance.Cliente.ClienteDadosRecords;

import br.com.CleanFinance.Endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosCadastroCliente(
                                    @NotBlank
                                    @Size(min = 2, message = "Mínimo 2 caracteres")
                                    String nome,
                                   @NotBlank
                                   @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
                                   String cpf,
                                   @NotBlank
                                    @Email
                                   String email,
                                   @Pattern(regexp = "^\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}$")
                                   String telefone,
                                   @NotNull
                                    @Valid
                                   DadosEndereco dadosEndereco) {
}
