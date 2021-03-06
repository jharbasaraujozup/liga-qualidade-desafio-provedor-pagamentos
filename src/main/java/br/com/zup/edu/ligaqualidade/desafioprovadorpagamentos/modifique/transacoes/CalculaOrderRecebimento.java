package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.transacoes;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.domain.OrdemDeRecebimento;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;

import java.time.LocalDate;

public class CalculaOrderRecebimento {

    Cartao cartaoDebito = new CartaoCredito();
    Cartao cartaoCredito = new CartaoCredito();

    OrdemDeRecebimento calculaOrderRecebimento(final DadosTransacao dadosTransacao, final DadosRecebimentoAdiantado dadosRecebimentoAdiantado){
        if (dadosTransacao.metodo.equals(MetodoPagamento.DEBITO)){
            return new OrdemDeRecebimento(
                    cartaoDebito.statusRecebimento(),
                    dadosTransacao.valor,
                    cartaoDebito.calculaValorRecebimentoDescontandoTaxaTransacao(dadosTransacao.valor),
                    cartaoDebito.calculaDataRecebimento(LocalDate.now())
            );
        }else {
            return new OrdemDeRecebimento(
                            cartaoCredito.statusRecebimento(),
                            dadosTransacao.valor,
                            cartaoCredito.calculaValorRecebimentoDescontandoTaxaTransacao(dadosTransacao.valor),
                            cartaoCredito.calculaDataRecebimento(LocalDate.now())
                       );
        }

    }

}
