package br.com.stocksmaps.core.crudOperations;

public interface IAtualizar<E, Key, Input> {

    E atualizar(Key id, Input input);

}
