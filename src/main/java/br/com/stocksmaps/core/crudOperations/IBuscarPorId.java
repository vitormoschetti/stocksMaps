package br.com.stocksmaps.core.crudOperations;

public interface IBuscarPorId<E, Key> {

    E buscarPorId(Key id);

}
