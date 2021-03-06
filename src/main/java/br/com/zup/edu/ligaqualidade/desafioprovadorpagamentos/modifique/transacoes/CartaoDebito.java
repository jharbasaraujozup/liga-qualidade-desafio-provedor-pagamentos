package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.transacoes;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.domain.StatusRecebimento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class CartaoDebito implements Cartao {

    private static final double VALOR_TAXA = 0.03;

    @Override
    public StatusRecebimento statusRecebimento() {
        return StatusRecebimento.PAGO;
    }

    @Override
    public LocalDate calculaDataRecebimento(LocalDate dataTransacao) {
        return dataTransacao;
    }

    @Override
    public BigDecimal calculaValorRecebimentoDescontandoTaxaTransacao(BigDecimal valorCompra) {
        var valorTaxa  = valorCompra.multiply(new BigDecimal(VALOR_TAXA)).setScale(0, RoundingMode.HALF_EVEN);
        return valorCompra.subtract(valorTaxa);
    }


}
