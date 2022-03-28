package br.com.stocksmaps.application.factories;

import br.com.stocksmaps.application.controllers.viewModel.CarteiraViewModel;
import br.com.stocksmaps.core.factories.IFactoryWithParams;
import br.com.stocksmaps.domain.entities.Carteira;
import org.springframework.stereotype.Component;

@Component
public class CarteiraParaCarteiraViewModel implements IFactoryWithParams<Carteira, CarteiraViewModel> {
    @Override
    public CarteiraViewModel create(Carteira carteira) {
        final var viewModel = new CarteiraViewModel();
        return viewModel;
    }
}
