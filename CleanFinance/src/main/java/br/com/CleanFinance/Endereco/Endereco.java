package br.com.CleanFinance.Endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @NotBlank
    private String cep;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String numero;
    @NotBlank
    private String bairro;
    private String complemento;
    @NotBlank
    private String localidade;
    @NotBlank
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.cep = dados.cep();
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.bairro = dados.bairro();
        this.complemento = dados.complemento();
        this.localidade = dados.localidade();
        this.uf = dados.uf();
    }

    public void AtualizarEndereco(DadosEndereco endereco) {
        if (endereco.cep() != null){
            this.cep = endereco.cep();
        }
        if (endereco.logradouro() != null){
            this.logradouro = endereco.logradouro();
        }
        if (endereco.numero() != null){
            this.numero = endereco.numero();
        }
        if (endereco.bairro() != null){
            this.bairro = endereco.bairro();
        }
        if (endereco.complemento() != null){
            this.complemento = endereco.complemento();
        }
        if (endereco.localidade() != null){
            this.localidade = endereco.localidade();
        }
        if (endereco.uf() != null){
            this.uf = endereco.uf();
        }
    }
}
