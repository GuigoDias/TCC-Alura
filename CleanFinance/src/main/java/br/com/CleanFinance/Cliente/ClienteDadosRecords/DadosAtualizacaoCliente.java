package br.com.CleanFinance.Cliente.ClienteDadosRecords;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(@NotNull Long id,
                                      String cpf,
                                      String nome,
                                      String telefone,
                                      String email) {
}
