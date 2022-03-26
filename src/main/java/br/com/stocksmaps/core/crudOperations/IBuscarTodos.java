package br.com.stocksmaps.core.crudOperations;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface IBuscarTodos<E> {

    Page<E> buscarTodos(Specification<E> spec, Pageable pageable);

}
