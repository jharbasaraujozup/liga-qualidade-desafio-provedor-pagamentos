package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.convert;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosRecebimentoAdiantado;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConvertInfoAdiantamentoToDadosRecebimentoAdiantamento {

    public List<DadosRecebimentoAdiantado> convertInfoAdiantamentoToDadosRecebimentoAdiantamento(final List<String> infoAdiantamentos){

       List<DadosRecebimentoAdiantado> listaDadosRecebimentoAdiantado = new ArrayList<>();
       for(String infoAdiantamento: infoAdiantamentos){
           final String[] adiantamento = infoAdiantamento.split(",");

           int idTransacao = Integer.valueOf(adiantamento[0]);
           BigDecimal taxa = new BigDecimal(adiantamento[1]);

           listaDadosRecebimentoAdiantado.add(
                   new DadosRecebimentoAdiantado(idTransacao, taxa)
           );
       }

       return listaDadosRecebimentoAdiantado ;
    }
}
