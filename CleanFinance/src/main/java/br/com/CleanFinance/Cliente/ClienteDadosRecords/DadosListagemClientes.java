package br.com.CleanFinance.Cliente.ClienteDadosRecords;

import br.com.CleanFinance.Cliente.Cliente;

public record DadosListagemClientes(
        Long id,
        String cpf,
        String nome,
        String email,
        String telefone,
        boolean status
) {

    public DadosListagemClientes(Cliente cliente){
        this(cliente.getId(),cliente.getCpf(),cliente.getNome(),cliente.getEmail(),cliente.getTelefone(),cliente.getStatus());
    }
}
