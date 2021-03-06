package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.transacoes;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.domain.OrdemDeRecebimento;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExecutaTransacao {

    List<OrdemDeRecebimento> listaOrdemRecebimento = new ArrayList<>();
    CalculaOrderRecebimento calculaOrderRecebimento = new CalculaOrderRecebimento();

    public List<OrdemDeRecebimento> executaTransacao(final List<DadosTransacao> listaDadosTransacao, final List<DadosRecebimentoAdiantado> listaDadosRecebimentoAdiantado){
        for(DadosTransacao dadosTransacao: listaDadosTransacao){
            final Optional<DadosRecebimentoAdiantado> dadosRecebimentoAdiantado = listaDadosRecebimentoAdiantado.stream().filter(recebimentoAdiantado -> recebimentoAdiantado.idTransacao == dadosTransacao.id).findAny();
            listaOrdemRecebimento.add( calculaOrderRecebimento.calculaOrderRecebimento( dadosTransacao, dadosRecebimentoAdiantado ));
        }
        return listaOrdemRecebimento;
    }
}
