package br.com.CleanFinance.Cliente;

import br.com.CleanFinance.Endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(
                                    @NotBlank
                                    String nome,
                                   @NotBlank
                                   @Pattern(regexp = "\\d{11}")
                                   String cpf,
                                   @NotBlank
                                    @Email
                                   String email,
                                   @Pattern(regexp = "\\d{10,12}")
                                   String telefone,
                                   @NotNull
                                    @Valid
                                   DadosEndereco dadosEndereco) {
}
