package br.com.CleanFinance.Compra;

import br.com.CleanFinance.Categoria.Categoria;
import br.com.CleanFinance.Endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Compra {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private double valor;
    private LocalDate data;
    @Embedded
    private Endereco estabelecimento;
    private String categoria;
}
