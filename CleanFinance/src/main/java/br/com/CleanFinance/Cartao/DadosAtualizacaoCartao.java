package br.com.CleanFinance.Cartao;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoCartao(@NotBlank Long id,
                                     boolean status
                                     ) {


}
