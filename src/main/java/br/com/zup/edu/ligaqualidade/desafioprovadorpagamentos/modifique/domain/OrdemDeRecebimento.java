package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrdemDeRecebimento {
    StatusRecebimento statusRecebimento;
    BigDecimal valorOriginal;
    BigDecimal valorASerRecebidoDeFato;
    LocalDate dataEsperadoRecebimento;

    public OrdemDeRecebimento(StatusRecebimento statusRecebimento, BigDecimal valorOriginal, BigDecimal valorASerRecebidoDeFato, LocalDate dataEsperadoRecebimento) {
        this.statusRecebimento = statusRecebimento;
        this.valorOriginal = valorOriginal;
        this.valorASerRecebidoDeFato = valorASerRecebidoDeFato;
        this.dataEsperadoRecebimento = dataEsperadoRecebimento;
    }
}
