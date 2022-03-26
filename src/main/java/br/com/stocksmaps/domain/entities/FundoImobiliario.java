package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.domain.enums.SegmentoFundoImobiliarioEnum;
import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import lombok.Getter;

@Getter
public class FundoImobiliario extends Ativo{

    private SegmentoFundoImobiliarioEnum fundoImobiliarioSegmento;

    public FundoImobiliario(SegmentoFundoImobiliarioEnum fundoImobiliarioSegmento) {
        super(TipoAtivoEnum.FUNDO_IMOBILIARIO);
        this.fundoImobiliarioSegmento = fundoImobiliarioSegmento;
    }
}
