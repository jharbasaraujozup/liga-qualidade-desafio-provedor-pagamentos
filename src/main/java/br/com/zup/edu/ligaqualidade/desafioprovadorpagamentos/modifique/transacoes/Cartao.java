package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.transacoes;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.domain.StatusRecebimento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public abstract class Cartao {

    protected abstract  double getTaxaOperacao();

    protected abstract  Integer getDaysForReceipt();

    protected abstract  StatusRecebimento getStatusDefault();

    public StatusRecebimento statusRecebimento() {
        return getStatusDefault();
    }

    public LocalDate calculaDataRecebimento(LocalDate dataTransacao) {
        return dataTransacao.plusDays(getDaysForReceipt());
    }

    public BigDecimal calculaValorRecebimentoDescontandoTaxaTransacao(BigDecimal valorCompra) {
        var valorTaxa  = valorCompra.multiply(new BigDecimal(getTaxaOperacao())).setScale(0, RoundingMode.HALF_EVEN);
        return valorCompra.subtract(valorTaxa);
    }
}
