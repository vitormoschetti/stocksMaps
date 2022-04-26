package br.com.stocksmaps.application.useCases;

import br.com.stocksmaps.core.useCases.IUseCaseWithParams;
import br.com.stocksmaps.domain.services.interfaces.ICarteiraService;
import org.springframework.stereotype.Service;

@Service
public class SincronizarCarteiraUseCase implements IUseCaseWithParams<Long, Void> {

    private final ICarteiraService carteiraService;

    public SincronizarCarteiraUseCase(ICarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @Override
    public Void execute(Long idCarteira) {

        this.carteiraService.sincronizarAtivos(idCarteira);

        return null;
    }
}
