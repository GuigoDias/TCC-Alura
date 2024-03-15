package br.com.CleanFinance.Compra;

import br.com.CleanFinance.Endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Compra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private LocalDateTime data;
    @Embedded
    private Endereco estabelecimento;
    private String categoria;

    public Compra(DadosCadastroCompra dados) {
        this.valor = dados.valor();
        this.data = LocalDateTime.now();
        this.estabelecimento = dados.estabelecimento();
        this.categoria = dados.categoria();
    }
}