package br.com.stocksMaps.core.useCases;

import br.com.stocksMaps.core.useCases.interfaces.IUseCase;

public abstract class BaseUseCase<Tout> implements IUseCase<Tout> {

    @Override
    public abstract Tout execute();

}
