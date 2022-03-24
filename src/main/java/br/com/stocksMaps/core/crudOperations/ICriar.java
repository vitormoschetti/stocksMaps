package br.com.stocksMaps.core.crudOperations;

public interface ICriar<TParam, E> {

    E criar(TParam param);

}
