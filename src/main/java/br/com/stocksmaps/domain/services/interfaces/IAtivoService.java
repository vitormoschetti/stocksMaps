package br.com.stocksmaps.domain.services.interfaces;

import br.com.stocksmaps.application.dtos.inputModel.AtivosInputModel;
import br.com.stocksmaps.core.services.IBaseService;
import br.com.stocksmaps.domain.entities.Carteira;
import br.com.stocksmaps.infra.data.models.AtivoModel;

public interface IAtivoService extends IBaseService<AtivoModel> {


    Carteira adicionar(Long idCarteira, AtivosInputModel input);
}
