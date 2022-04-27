package br.com.stocksmaps.application.useCases;

import br.com.stocksmaps.core.useCases.IUseCaseWithParams;
import br.com.stocksmaps.domain.entities.Carteira;
import br.com.stocksmaps.domain.services.interfaces.ICarteiraService;
import org.springframework.stereotype.Service;

@Service
public class SincronizarCarteiraUseCase implements IUseCaseWithParams<Long, Carteira> {

    private final ICarteiraService carteiraService;

    public SincronizarCarteiraUseCase(ICarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @Override
    public Carteira execute(Long idCarteira) {

        return this.carteiraService.sincronizarAtivos(idCarteira);

    }
}
