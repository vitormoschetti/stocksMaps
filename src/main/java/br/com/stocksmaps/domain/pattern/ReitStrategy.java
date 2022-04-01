package br.com.stocksmaps.domain.pattern;

import br.com.stocksmaps.application.dtos.inputModel.AtivoInputModel;
import br.com.stocksmaps.domain.entities.Reit;
import br.com.stocksmaps.domain.enums.SegmentoReitEnum;

public class ReitStrategy implements Strategy<Reit> {

    @Override
    public Reit create(AtivoInputModel input) {
        final var reit = new Reit(SegmentoReitEnum.valueOf(input.getSegmento()));
        reit.criarAtivo(input);
        return reit;
    }
}