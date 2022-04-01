package br.com.stocksmaps.domain.pattern;

import br.com.stocksmaps.application.dtos.inputModel.AtivoInputModel;

public interface Strategy<T> {

    T create(AtivoInputModel input);

}
