package br.com.stocksmaps.core.factories;

public interface IFactoryWithParams <TParams, TOut>{

    TOut create(TParams params);

}
