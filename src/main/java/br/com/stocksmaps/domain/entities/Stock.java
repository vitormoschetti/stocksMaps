package br.com.stocksmaps.domain.entities;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Stock extends Ativo {

    public void sincronizar(yahoofinance.Stock stock) {
        BigDecimal cotacao = stock.getQuote().getPrice();
        this.atualizarPrecoAtual(cotacao);
    }
}
