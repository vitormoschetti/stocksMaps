package br.com.stocksmaps.application.useCases;

import br.com.stocksmaps.application.dtos.viewModel.CarteiraViewModel;
import br.com.stocksmaps.application.factories.CarteiraParaCarteiraViewModel;
import br.com.stocksmaps.core.useCases.IUseCaseWithParams;
import br.com.stocksmaps.domain.entities.Carteira;
import br.com.stocksmaps.domain.services.interfaces.ICarteiraService;
import org.springframework.stereotype.Service;

@Service
public class SincronizarCarteiraUseCase implements IUseCaseWithParams<Long, CarteiraViewModel> {

    private final ICarteiraService carteiraService;
    private final CarteiraParaCarteiraViewModel factory;

    public SincronizarCarteiraUseCase(ICarteiraService carteiraService, CarteiraParaCarteiraViewModel factory) {
        this.carteiraService = carteiraService;
        this.factory = factory;
    }

    @Override
    public CarteiraViewModel execute(Long idCarteira) {

        final var carteira = this.carteiraService.sincronizarAtivos(idCarteira);

        return this.factory.create(carteira);

    }
}
