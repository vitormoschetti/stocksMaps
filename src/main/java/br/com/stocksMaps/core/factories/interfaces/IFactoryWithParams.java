package br.com.stocksMaps.core.factories.interfaces;

public interface IFactoryWithParams <TParams, TOut>{

    TOut create(TParams params);

}
