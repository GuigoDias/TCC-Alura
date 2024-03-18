package br.com.CleanFinance.Cartao;

import br.com.CleanFinance.Cliente.Cliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "clientes")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "numero")
public class Cartao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String numero;
    @ManyToOne @NotBlank
    private Cliente cliente;
    @NotBlank
    private String validade;
    @NotBlank
    private String cvv;
    @NotNull
    private BigDecimal limite;
    @NotNull
    private boolean status;

    public Cartao(DadosCadastroCartao dados) {
        this.numero = criarNumero();
        this.cliente = dados.cliente();
        this.validade = criarValidade();
        this.cvv = criarCvv();
        this.limite = dados.limite();
        this.status = true;
    }

    private String criarNumero(){
        int numeroCompleto = 0;
        for (int num = 0;num < 16;num++){
           var numero = ((int) Math.random()*10);
           numeroCompleto =+ numero;
        }
        return String.valueOf(numeroCompleto);
    }

    private String criarCvv(){
        int numeroCompleto = 0;
        for (int num = 0;num < 3;num++){
            var numero = ((int) Math.random()*10);
            numeroCompleto =+ numero;
        }
        return String.valueOf(numeroCompleto);
    }

    public void ativarOuDesativar(DadosAtualizacaoCartao dados) {
        if (dados.status() == true){
            this.status = false;
        }
        if (dados.status() == false) {
            this.status = true;
        }
    }

    private String criarValidade(){
        LocalDate data = LocalDate.now().plusYears(4).plusMonths(6);
        String mes = String.format("%02d", data.getMonthValue());
        String ano = String.valueOf(data.getYear());
        return mes + "-" + ano;
    }

    public void alterarLimite(BigDecimal novoLimite) {
        if (novoLimite != null){
            this.limite = novoLimite;
        }
    }
}