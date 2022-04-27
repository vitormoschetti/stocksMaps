package br.com.stocksmaps.domain.services.interfaces;

import br.com.stocksmaps.application.dtos.inputModel.CarteiraInputModel;
import br.com.stocksmaps.application.dtos.viewModel.CarteiraViewModel;
import br.com.stocksmaps.core.services.IBaseService;
import br.com.stocksmaps.domain.entities.Carteira;
import br.com.stocksmaps.infra.data.models.CarteiraModel;

public interface ICarteiraService extends IBaseService<CarteiraModel> {
    CarteiraViewModel criarCarteira(CarteiraInputModel carteiraInputModel);

    Carteira sincronizarAtivos(Long idCarteira);
}

