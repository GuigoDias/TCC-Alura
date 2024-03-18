package br.com.CleanFinance.Cartao.CartaoDadosRecords;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoCartao(@NotBlank Long id,
                                     boolean status
                                     ) {


}
