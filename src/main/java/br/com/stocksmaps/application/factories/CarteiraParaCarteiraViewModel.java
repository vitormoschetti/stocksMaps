package br.com.stocksmaps.application.factories;

import br.com.stocksmaps.application.dtos.viewModel.AtivoViewModel;
import br.com.stocksmaps.application.dtos.viewModel.CarteiraViewModel;
import br.com.stocksmaps.core.factories.IFactoryWithParams;
import br.com.stocksmaps.domain.entities.Carteira;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarteiraParaCarteiraViewModel implements IFactoryWithParams<Carteira, CarteiraViewModel> {

    @Override
    public CarteiraViewModel create(Carteira carteira) {

        final var ativoViewModel = new AtivoViewModel();

        final var acoes = ativoViewModel.converter(carteira.getAcoes());
        final var stocks = ativoViewModel.converter(carteira.getStocks());
        final var fiis = ativoViewModel.converter(carteira.getFundosImobiliarios());

        return new CarteiraViewModel(carteira, acoes, stocks, fiis);
    }

}
