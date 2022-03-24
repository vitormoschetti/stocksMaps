package br.com.stocksMaps.core.crudOperations;

public interface IBuscarPorId<E, Key> {

    E buscarPorId(Key id);

}
