package br.com.stocksMaps.core.useCases;

import br.com.stocksMaps.core.useCases.interfaces.IUseCaseWithParams;

public abstract class BaseUseCaseWithParams<TParams, Tout> implements IUseCaseWithParams<TParams, Tout> {

    @Override
    public abstract Tout execute(TParams params);

}
