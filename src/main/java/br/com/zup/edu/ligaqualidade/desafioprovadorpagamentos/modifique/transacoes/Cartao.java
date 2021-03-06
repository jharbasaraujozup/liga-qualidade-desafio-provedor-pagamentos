package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.transacoes;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.domain.StatusRecebimento;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Cartao {

    StatusRecebimento statusRecebimento();

    LocalDate calculaDataRecebimento(LocalDate dataTransacao);

    BigDecimal calculaValorRecebimentoDescontandoTaxaTransacao(BigDecimal valorCompra);
}
