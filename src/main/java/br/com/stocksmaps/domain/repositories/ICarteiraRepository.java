package br.com.stocksmaps.domain.repositories;

import br.com.stocksmaps.core.IRepository;
import br.com.stocksmaps.core.crudOperations.ICriar;
import br.com.stocksmaps.domain.entities.Carteira;
import br.com.stocksmaps.infra.data.models.CarteiraModel;

public interface ICarteiraRepository extends IRepository<CarteiraModel>, ICriar<Carteira, Carteira> {

}
