package br.com.stocksmaps.application.factories;

import br.com.stocksmaps.application.controllers.inputModel.CarteiraInputModel;
import br.com.stocksmaps.core.factories.IFactoryWithParams;
import br.com.stocksmaps.domain.entities.Carteira;
import org.springframework.stereotype.Component;

@Component
public class CarteiraInputModelParaCarteira implements IFactoryWithParams<CarteiraInputModel, Carteira> {

    @Override
    public Carteira create(CarteiraInputModel carteiraInputModel) {

        final var carteira = new Carteira();
        carteira.criarNovo(carteiraInputModel.getNome());

        return carteira;
    }
}
