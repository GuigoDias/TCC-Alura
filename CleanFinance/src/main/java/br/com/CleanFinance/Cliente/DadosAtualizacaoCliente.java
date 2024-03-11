package br.com.CleanFinance.Cliente;

import br.com.CleanFinance.Endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(@NotNull Long id,
                                      String nome,
                                      String telefone,
                                      DadosEndereco endereco) {
}
