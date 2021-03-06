package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique.convert;

import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.DadosTransacao;
import br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.pronto.MetodoPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertInfoTransacoesToDadosTransacao {

    public List<DadosTransacao> convertInfoTransacoesToDadosTransacao(final List<String> infoTransacoes){

         List<DadosTransacao> listaDadosTransacao = new ArrayList<>();

         for(String infoTransacao : infoTransacoes){
             final String[] transacao = infoTransacao.split(",");

             BigDecimal valor = new BigDecimal(transacao[0]);
             MetodoPagamento metodo = "DEBITO".equals(transacao[1]) ? MetodoPagamento.DEBITO : MetodoPagamento.CREDITO;
             String numero = transacao[2];
             String nome = transacao[3];
             final String[] date = transacao[4].split("/");
             LocalDate validade = LocalDate.of( Integer.valueOf(date[2]), Integer.valueOf(date[1]), Integer.valueOf(date[0]) );
             int cvv = Integer.valueOf(transacao[5]);
             int id = Integer.valueOf(transacao[6]);

             listaDadosTransacao.add(
                 new DadosTransacao(valor,
                         metodo,
                         numero,
                         nome,
                         validade,
                         cvv,
                         id
                 )
             );
         }


        return listaDadosTransacao;

    }
}
