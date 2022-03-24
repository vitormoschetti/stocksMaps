package br.com.stocksMaps.core.crudOperations;

public interface IAtualizar<E, Key, Input> {

    E atualizar(Key id, Input input);

}
