package br.com.stocksmaps.application.useCases;

import br.com.stocksmaps.application.dtos.inputModel.AtivosInputModel;
import br.com.stocksmaps.application.dtos.viewModel.CarteiraViewModel;
import br.com.stocksmaps.application.factories.CarteiraParaCarteiraViewModel;
import br.com.stocksmaps.core.useCases.IUseCaseWithParams;
import br.com.stocksmaps.domain.services.interfaces.IAtivoService;
import br.com.stocksmaps.domain.services.interfaces.ICarteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.util.function.Tuple2;

import javax.transaction.Transactional;

@Service
public class AdicionarAtivoUseCase implements IUseCaseWithParams<Tuple2<Long, AtivosInputModel>, CarteiraViewModel> {

    private final IAtivoService ativoService;
    private final ICarteiraService carteiraService;
    private final CarteiraParaCarteiraViewModel factory;

    @Autowired
    public AdicionarAtivoUseCase(IAtivoService ativoService, ICarteiraService carteiraService, CarteiraParaCarteiraViewModel factory) {
        this.ativoService = ativoService;
        this.carteiraService = carteiraService;
        this.factory = factory;
    }

    @Override
    @Transactional
    public CarteiraViewModel execute(Tuple2<Long, AtivosInputModel> params) {

        final var idCarteira = params.getT1();
        final var input = params.getT2();

        this.ativoService.adicionar(idCarteira, input);

        final var carteira = this.carteiraService.sincronizarAtivos(idCarteira);

        return this.factory.create(carteira);
    }
}
