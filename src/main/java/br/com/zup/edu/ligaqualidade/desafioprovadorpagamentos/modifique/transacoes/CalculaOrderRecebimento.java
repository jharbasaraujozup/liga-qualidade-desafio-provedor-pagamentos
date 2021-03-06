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

    Cartao cartao;

    CalculaOrderRecebimento(MetodoPagamento metodoPagamento) {
        this.cartao = metodoPagamento == MetodoPagamento.DEBITO ? new CartaoDebito() : new CartaoCredito();
    }

    OrdemDeRecebimento calculaOrderRecebimento(final DadosTransacao dadosTransacao,
        final Optional<DadosRecebimentoAdiantado> dadosRecebimentoAdiantado) {

        OrdemDeRecebimento recebimento = new OrdemDeRecebimento(
            cartao.getStatusDefault(),
            dadosTransacao.valor,
            cartao.calculaValorRecebimentoDescontandoTaxaTransacao(dadosTransacao.valor),
            cartao.calculaDataRecebimento(LocalDate.now())
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
