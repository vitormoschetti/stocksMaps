package br.com.stocksmaps.domain.pattern;

import br.com.stocksmaps.application.dtos.inputModel.AtivoInputModel;
import br.com.stocksmaps.domain.entities.FundoImobiliario;
import br.com.stocksmaps.domain.enums.SegmentoFundoImobiliarioEnum;

public class FundoImobiliarioStrategy implements Strategy<FundoImobiliario> {

    @Override
    public FundoImobiliario create(AtivoInputModel input) {
        final var fii = new FundoImobiliario(SegmentoFundoImobiliarioEnum.valueOf(input.getSegmento()));
        fii.criarAtivo(input);
        return fii;
    }
}
