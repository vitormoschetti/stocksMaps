package br.com.stocksmaps.domain.pattern;

import br.com.stocksmaps.domain.entities.Ativo;
import br.com.stocksmaps.domain.entities.Stock;
import br.com.stocksmaps.domain.pattern.interfaces.FactoryAtivo;

public class StockFactory implements FactoryAtivo<Stock> {

    @Override
    public Stock create(Ativo input) {
        return new Stock(input);
    }
}