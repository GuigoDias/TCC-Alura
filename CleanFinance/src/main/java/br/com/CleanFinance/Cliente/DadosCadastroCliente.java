package br.com.CleanFinance.Cliente;

import br.com.CleanFinance.Endereco.DadosEndereco;

public record DadosCadastroCliente(String nome,
                                   String cpf,
                                   String email,
                                   String telefone,
                                   DadosEndereco dadosEndereco) {
}
