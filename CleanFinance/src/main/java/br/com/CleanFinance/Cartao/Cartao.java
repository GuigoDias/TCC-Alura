package br.com.CleanFinance.Cartao;

import br.com.CleanFinance.Cartao.CartaoDadosRecords.DadosAtualizacaoCartao;
import br.com.CleanFinance.Cartao.CartaoDadosRecords.DadosCadastroCartao;
import br.com.CleanFinance.Compra.Compra;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
    @NotNull
    @Column(name = "cliente_id")
    private Long clienteId;
    @NotBlank
    private String validade;
    @NotBlank
    private String cvv;
    @NotNull
    private BigDecimal limite;
    @NotNull
    private boolean status;
    @OneToMany
    private List<Compra> compras;

    public Cartao(DadosCadastroCartao dados) {
        this.numero = criarNumero();
        this.clienteId = dados.clienteId();
        this.validade = criarValidade();
        this.cvv = criarCvv();
        this.limite = dados.limite();
        this.status = true;
    }

    private String criarNumero(){
        String numeroCompleto = "";
        for (int num = 0;num < 16;num++){
           var numero = String.valueOf((int)(Math.random()*10));
           numeroCompleto += numero;
        }
        return numeroCompleto;
    }

    private String criarCvv(){
        String numeroCompleto = "";
        for (int num = 0;num < 3;num++){
            var numero = String.valueOf((int)(Math.random()*10));
            numeroCompleto += numero;
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