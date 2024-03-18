package br.com.CleanFinance.Cliente.ClienteDadosRecords;

import br.com.CleanFinance.Cliente.Cliente;

public record DadosListagemClientes(
        String cpf,
        String nome,
        String email,
        String telefone
) {

    public DadosListagemClientes(Cliente cliente){
        this(cliente.getCpf(),cliente.getNome(),cliente.getEmail(),cliente.getTelefone());
    }
}
