package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.transacoes;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.domain.OrdemDeRecebimento;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.domain.StatusRecebimento;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Optional;

public class CalculaOrderRecebimento {

    Cartao cartaoDebito = new CartaoDebito();
    Cartao cartaoCredito = new CartaoCredito();

    OrdemDeRecebimento calculaOrderRecebimento(final DadosTransacao dadosTransacao,
        final Optional<DadosRecebimentoAdiantado> dadosRecebimentoAdiantado) {
        if (dadosTransacao.metodo.equals(MetodoPagamento.DEBITO)) {
            return new OrdemDeRecebimento(
                cartaoDebito.statusRecebimento(),
                dadosTransacao.valor,
                cartaoDebito.calculaValorRecebimentoDescontandoTaxaTransacao(dadosTransacao.valor),
                cartaoDebito.calculaDataRecebimento(LocalDate.now())
            );
        } else {
            OrdemDeRecebimento recebimento = new OrdemDeRecebimento(
                cartaoCredito.statusRecebimento(),
                dadosTransacao.valor,
                cartaoCredito.calculaValorRecebimentoDescontandoTaxaTransacao(dadosTransacao.valor),
                cartaoCredito.calculaDataRecebimento(LocalDate.now())
            );

            if (dadosRecebimentoAdiantado.isPresent()) {
                recebimento.setStatusRecebimento(StatusRecebimento.PAGO);
                recebimento.setDataEsperadoRecebimento(LocalDate.now());

                BigDecimal valorTaxaAdiantamento = recebimento.getValorASerRecebidoDeFato().multiply(dadosRecebimentoAdiantado.get().taxa);
                recebimento.setValorASerRecebidoDeFato(recebimento.getValorASerRecebidoDeFato().subtract(valorTaxaAdiantamento.setScale(0, RoundingMode.DOWN)));
            }

            return recebimento;
        }

    }

}
