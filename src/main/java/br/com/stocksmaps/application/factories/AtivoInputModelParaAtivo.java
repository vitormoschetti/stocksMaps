package br.com.stocksmaps.application.factories;

import br.com.stocksmaps.application.dtos.inputModel.AtivoInputModel;
import br.com.stocksmaps.core.factories.IFactoryWithParams;
import br.com.stocksmaps.domain.entities.Ativo;
import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import br.com.stocksmaps.domain.pattern.AcaoStrategy;
import br.com.stocksmaps.domain.pattern.FundoImobiliarioStrategy;
import br.com.stocksmaps.domain.pattern.ReitStrategy;
import br.com.stocksmaps.domain.pattern.StockStrategy;
import org.springframework.stereotype.Component;

@Component
public class AtivoInputModelParaAtivo implements IFactoryWithParams<AtivoInputModel, Ativo> {

    @Override
    public Ativo create(AtivoInputModel input) {

        if (input.getTipoAtivo().equals(TipoAtivoEnum.ACAO))
            return new AcaoStrategy().create(input);
        if (input.getTipoAtivo().equals(TipoAtivoEnum.FUNDO_IMOBILIARIO))
            return new FundoImobiliarioStrategy().create(input);
        if (input.getTipoAtivo().equals(TipoAtivoEnum.REIT))
            return new ReitStrategy().create(input);

        return new StockStrategy().create(input);

    }
}









