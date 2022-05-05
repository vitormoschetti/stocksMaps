package br.com.stocksmaps.application.useCases;

import br.com.stocksmaps.application.dtos.inputModel.CarteiraInputModel;
import br.com.stocksmaps.application.dtos.viewModel.CarteiraViewModel;
import br.com.stocksmaps.application.factories.CarteiraParaCarteiraViewModel;
import br.com.stocksmaps.core.useCases.IUseCaseWithParams;
import br.com.stocksmaps.domain.services.interfaces.ICarteiraService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CriarCarteiraUseCase implements IUseCaseWithParams<CarteiraInputModel, CarteiraViewModel> {

    private final ICarteiraService carteiraService;
    private final CarteiraParaCarteiraViewModel factory;


    public CriarCarteiraUseCase(ICarteiraService carteiraService, CarteiraParaCarteiraViewModel factory) {
        this.carteiraService = carteiraService;
        this.factory = factory;
    }

    @Override
    @Transactional
    public CarteiraViewModel execute(CarteiraInputModel carteiraInputModel) {

        final var carteira = this.carteiraService.criarCarteira(carteiraInputModel);

        return this.factory.create(carteira);

    }
}
