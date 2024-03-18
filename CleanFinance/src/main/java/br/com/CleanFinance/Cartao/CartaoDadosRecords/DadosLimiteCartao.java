package br.com.CleanFinance.Cartao.CartaoDadosRecords;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record DadosLimiteCartao(@NotBlank String numero,
                                BigDecimal novoLimite
                                ) {
}
