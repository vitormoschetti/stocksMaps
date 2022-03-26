package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.domain.enums.SegmentoReitEnum;
import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import lombok.Getter;

@Getter
public class Reit extends Ativo{

    private SegmentoReitEnum segmentoReit;

    public Reit(SegmentoReitEnum segmentoReit) {
        super(TipoAtivoEnum.REIT);
        this.segmentoReit = segmentoReit;
    }
}
