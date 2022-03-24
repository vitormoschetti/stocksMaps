package br.com.stocksMaps.core.factories;

import br.com.stocksMaps.core.factories.interfaces.IFactory;

public abstract class BaseFactory<Tout> implements IFactory<Tout> {

    @Override
    public abstract Tout create();

}
