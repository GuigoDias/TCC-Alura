package br.com.CleanFinance.Compra;

import br.com.CleanFinance.Endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private BigDecimal valor;
    @NotNull
    private LocalDateTime data;
    @Embedded
    private Endereco estabelecimento;
    @NotBlank
    private String categoria;

    public Compra(DadosCadastroCompra dados) {
        this.valor = dados.valor();
        this.data = LocalDateTime.now();
        this.estabelecimento = dados.estabelecimento();
        this.categoria = dados.categoria();
    }
}