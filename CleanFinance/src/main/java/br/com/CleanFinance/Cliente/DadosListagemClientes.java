package br.com.CleanFinance.Cliente;

public record DadosListagemClientes(
        Long id,
        String cpf,
        String nome,
        String email,
        String telefone
) {

    public DadosListagemClientes(Cliente cliente){
        this(cliente.getId(),cliente.getCpf(),cliente.getNome(),cliente.getEmail(),cliente.getTelefone());
    }
}
