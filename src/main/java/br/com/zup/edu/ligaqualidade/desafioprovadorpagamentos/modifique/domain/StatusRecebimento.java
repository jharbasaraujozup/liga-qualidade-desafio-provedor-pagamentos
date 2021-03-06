package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.domain;

public enum StatusRecebimento {
    PAGO("pago"),
    AGUARDANDO_PAGAMENTO("aguardando_pagamento");

    public String status;

    StatusRecebimento(String status) {
        this.status = status;
    }
}
