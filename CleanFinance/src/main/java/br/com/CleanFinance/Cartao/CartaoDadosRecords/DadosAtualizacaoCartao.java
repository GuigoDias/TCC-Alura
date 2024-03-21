package br.com.CleanFinance.Cartao.CartaoDadosRecords;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCartao(@NotNull Long id,
                                     boolean status
                                     ) {


}
