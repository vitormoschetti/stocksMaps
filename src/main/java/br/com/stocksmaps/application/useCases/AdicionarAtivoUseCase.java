package br.com.stocksmaps.application.useCases;

import br.com.stocksmaps.application.dtos.inputModel.AtivosInputModel;
import br.com.stocksmaps.core.useCases.IUseCaseWithParams;
import br.com.stocksmaps.domain.entities.Carteira;
import br.com.stocksmaps.domain.services.interfaces.IAtivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.util.function.Tuple2;

@Service
public class AdicionarAtivoUseCase implements IUseCaseWithParams<Tuple2<Long, AtivosInputModel>, Carteira> {

    private final IAtivoService ativoService;

    @Autowired
    public AdicionarAtivoUseCase(IAtivoService ativoService) {
        this.ativoService = ativoService;
    }

    @Override
    public Carteira execute(Tuple2<Long, AtivosInputModel> params) {

        final var idCarteira = params.getT1();
        final var input = params.getT2();

        return this.ativoService.adicionar(idCarteira, input);
    }
}
