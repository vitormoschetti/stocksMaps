package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.domain.enums.SetorStockEnum;
import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import lombok.Getter;

@Getter
public class Stock extends Ativo{

    private SetorStockEnum segmentoStock;

    Stock(SetorStockEnum segmentoStock){
        super(TipoAtivoEnum.STOCK);
        this.segmentoStock = segmentoStock;
    }
}
