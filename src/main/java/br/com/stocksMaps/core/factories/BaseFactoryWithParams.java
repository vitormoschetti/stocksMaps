package br.com.stocksMaps.core.factories;

import br.com.stocksMaps.core.factories.interfaces.IFactoryWithParams;

public abstract class BaseFactoryWithParams<TParams, Tout> implements IFactoryWithParams<TParams, Tout> {

    @Override
    public abstract Tout create(TParams params);

}
