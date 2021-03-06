package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.transacoes;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.domain.StatusRecebimento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CartaoCredito implements Cartao {

    private static final double VALOR_TAXA = 0.05;

    @Override
    public StatusRecebimento statusRecebimento() {
        return StatusRecebimento.PAGO;
    }

    @Override
    public LocalDate calculaDataRecebimento(LocalDate dataTransacao) {

        return dataTransacao.plusDays(30);
    }

    @Override
    public BigDecimal calculaValorRecebimentoDescontandoTaxaTransacao(BigDecimal valorCompra) {
        var valorTaxa  = valorCompra.multiply(new BigDecimal(VALOR_TAXA));
        return valorCompra.subtract(valorTaxa);
    }
}
