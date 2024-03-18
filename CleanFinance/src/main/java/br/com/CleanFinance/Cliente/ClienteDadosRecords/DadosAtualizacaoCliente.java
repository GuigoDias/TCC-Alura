package br.com.CleanFinance.Cliente.ClienteDadosRecords;

import br.com.CleanFinance.Endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(@NotNull Long id,
                                      String cpf,
                                      String nome,
                                      String telefone,
                                      DadosEndereco endereco) {
}
