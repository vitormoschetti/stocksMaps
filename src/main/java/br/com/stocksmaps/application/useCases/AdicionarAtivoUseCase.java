package br.com.stocksmaps.application.useCases;

import br.com.stocksmaps.application.dtos.inputModel.AtivosInputModel;
import br.com.stocksmaps.core.useCases.IUseCaseWithParams;
import br.com.stocksmaps.domain.entities.Carteira;
import br.com.stocksmaps.domain.services.interfaces.IAtivoService;
import br.com.stocksmaps.domain.services.interfaces.ICarteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.util.function.Tuple2;

import javax.transaction.Transactional;

@Service
public class AdicionarAtivoUseCase implements IUseCaseWithParams<Tuple2<Long, AtivosInputModel>, Carteira> {

    private final IAtivoService ativoService;
    private final ICarteiraService carteiraService;

    @Autowired
    public AdicionarAtivoUseCase(IAtivoService ativoService, ICarteiraService carteiraService) {
        this.ativoService = ativoService;
        this.carteiraService = carteiraService;
    }

    @Override
    @Transactional
    public Carteira execute(Tuple2<Long, AtivosInputModel> params) {

        final var idCarteira = params.getT1();
        final var input = params.getT2();

        this.ativoService.adicionar(idCarteira, input);

        return this.carteiraService.sincronizarAtivos(idCarteira);
    }
}
