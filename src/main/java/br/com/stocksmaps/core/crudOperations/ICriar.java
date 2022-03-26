package br.com.stocksmaps.core.crudOperations;

public interface ICriar<TParam, E> {

    E criar(TParam param);

}
