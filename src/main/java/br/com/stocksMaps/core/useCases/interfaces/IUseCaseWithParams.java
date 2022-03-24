package br.com.stocksMaps.core.useCases.interfaces;

public interface IUseCaseWithParams<TParams, Tout> {

    Tout execute(TParams params);

}
