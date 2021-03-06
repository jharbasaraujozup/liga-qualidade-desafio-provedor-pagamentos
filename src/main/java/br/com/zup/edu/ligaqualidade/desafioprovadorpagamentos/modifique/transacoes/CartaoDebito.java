package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.transacoes;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.domain.StatusRecebimento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class CartaoDebito extends Cartao {

    private static final double VALOR_TAXA = 0.03;
    private static final Integer DAYS_FOR_RECEIPT = 0;
    private static final StatusRecebimento STATUS_DEFAULT = StatusRecebimento.PAGO;

    @Override
    public double getTaxaOperacao() {
        return VALOR_TAXA;
    }

    @Override
    protected Integer getDaysForReceipt() {
        return DAYS_FOR_RECEIPT;
    }

    @Override
    protected StatusRecebimento getStatusDefault() {
        return STATUS_DEFAULT;
    }
}
