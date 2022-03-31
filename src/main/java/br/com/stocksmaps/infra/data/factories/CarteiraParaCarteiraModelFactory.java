package br.com.stocksmaps.infra.data.factories;

import br.com.stocksmaps.core.factories.IFactoryWithParams;
import br.com.stocksmaps.domain.entities.Carteira;
import br.com.stocksmaps.infra.data.models.CarteiraModel;
import org.springframework.stereotype.Component;

@Component
public class CarteiraParaCarteiraModelFactory implements IFactoryWithParams<Carteira, CarteiraModel> {

    @Override
    public CarteiraModel create(Carteira carteira) {
        final var model = new CarteiraModel();
        model.criarNovo(carteira);
        return model;
    }
}
