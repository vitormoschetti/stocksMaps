package br.com.stocksmaps.application.useCases;

import br.com.stocksmaps.application.controllers.inputModel.CarteiraInputModel;
import br.com.stocksmaps.application.controllers.viewModel.CarteiraViewModel;
import br.com.stocksmaps.core.useCases.IUseCaseWithParams;
import br.com.stocksmaps.domain.services.interfaces.ICarteiraService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CriarCarteiraUseCase implements IUseCaseWithParams<CarteiraInputModel, CarteiraViewModel> {

    private final ICarteiraService carteiraService;

    public CriarCarteiraUseCase(ICarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @Override
    @Transactional
    public CarteiraViewModel execute(CarteiraInputModel carteiraInputModel) {

        return this.carteiraService.criarCarteira(carteiraInputModel);

    }
}
