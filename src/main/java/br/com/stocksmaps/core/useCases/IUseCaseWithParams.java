package br.com.stocksmaps.core.useCases;

public interface IUseCaseWithParams<TParams, Tout> {

    Tout execute(TParams params);

}
