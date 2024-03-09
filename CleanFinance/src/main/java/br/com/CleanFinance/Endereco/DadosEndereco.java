package br.com.CleanFinance.Endereco;

public record DadosEndereco(String cep,
                            String logradouro,
                            String numero,
                            String bairro,
                            String complemento,

                            String localidade,
                            String uf) {
}