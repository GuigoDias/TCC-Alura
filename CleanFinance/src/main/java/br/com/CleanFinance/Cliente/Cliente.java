package br.com.CleanFinance.Cliente;

import br.com.CleanFinance.Cartao.Cartao;
import br.com.CleanFinance.Endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "clientes")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;
    @Embedded
    private Endereco endereco;
    @OneToMany
    private List<Cartao> cartoes;
    private boolean ativo;

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.dadosEndereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoCliente dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.cpf() != null){
            this.cpf = dados.cpf();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null){
            this.endereco.AtualizarEndereco(dados.endereco());
        }
    }

    public void exclusao() {
        this.ativo = false;
    }
}
