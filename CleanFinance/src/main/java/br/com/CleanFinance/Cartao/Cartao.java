package br.com.CleanFinance.Cartao;

import br.com.CleanFinance.Cliente.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "clientes")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "numero")
public class Cartao {
    @Id @NotNull
    private int numero;
    @ManyToOne @NotBlank
    private Cliente cliente;
    @NotNull
    private LocalDate validade;
    @NotNull
    private int cvv;
    @NotNull
    private double limite;
    @NotNull
    private boolean status;

    public Cartao(DadosCadastroCartao dados) {
        this.numero = criarNumero();
        this.cliente = dados.cliente();
        this.validade = LocalDate.now();
        this.cvv = criarCvv();
        this.limite = dados.limite();
        this.status = true;
    }

    private int criarNumero(){
        int numeroCompleto = 0;
        for (int num = 0;num < 16;num++){
           var numero = ((int) Math.random()*10);
           numeroCompleto =+ numero;
        }
        return numeroCompleto;
    }

    private int criarCvv(){
        int numeroCompleto = 0;
        for (int num = 0;num < 3;num++){
            var numero = ((int) Math.random()*10);
            numeroCompleto =+ numero;
        }
        return numeroCompleto;
    }

    public void ativarOuDesativar(DadosAtualizacaoCartao dados) {
        if (dados.status() == true){
            this.status = false;
        }
        if (dados.status() == false) {
            this.status = true;
        }
    }
}
