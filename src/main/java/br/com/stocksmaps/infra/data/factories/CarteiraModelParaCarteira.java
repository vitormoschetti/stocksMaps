package br.com.stocksmaps.infra.data.factories;

import br.com.stocksmaps.core.factories.IFactoryWithParams;
import br.com.stocksmaps.domain.entities.Carteira;
import br.com.stocksmaps.infra.data.models.CarteiraModel;
import org.springframework.stereotype.Component;

@Component
public class CarteiraModelParaCarteira implements IFactoryWithParams<CarteiraModel, Carteira> {

    @Override
    public Carteira create(CarteiraModel carteiraModel) {
        final var entity = new Carteira();
        entity.criarNovo(carteiraModel.getNome());
        return entity;
    }
}
