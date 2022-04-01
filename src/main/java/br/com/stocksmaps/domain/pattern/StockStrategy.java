package br.com.stocksmaps.domain.pattern;

import br.com.stocksmaps.application.dtos.inputModel.AtivoInputModel;
import br.com.stocksmaps.domain.entities.Stock;
import br.com.stocksmaps.domain.enums.SetorStockEnum;

public class StockStrategy implements Strategy<Stock> {

    @Override
    public Stock create(AtivoInputModel input) {
        final var stock = new Stock(SetorStockEnum.valueOf(input.getSegmento()));
        stock.criarAtivo(input);
        return stock;
    }
}