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

    public StatusRecebimento getStatusRecebimento() {
        return statusRecebimento;
    }

    public void setStatusRecebimento(
        StatusRecebimento statusRecebimento) {
        this.statusRecebimento = statusRecebimento;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public BigDecimal getValorASerRecebidoDeFato() {
        return valorASerRecebidoDeFato;
    }

    public void setValorASerRecebidoDeFato(BigDecimal valorASerRecebidoDeFato) {
        this.valorASerRecebidoDeFato = valorASerRecebidoDeFato;
    }

    public LocalDate getDataEsperadoRecebimento() {
        return dataEsperadoRecebimento;
    }

    public void setDataEsperadoRecebimento(LocalDate dataEsperadoRecebimento) {
        this.dataEsperadoRecebimento = dataEsperadoRecebimento;
    }

}
