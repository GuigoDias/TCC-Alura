package br.com.CleanFinance.Categoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nome;
    private boolean ativo;
}
