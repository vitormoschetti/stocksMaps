package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.domain.enums.SetorAcaoEnum;
import br.com.stocksmaps.domain.enums.TipoAtivoEnum;
import lombok.Getter;

@Getter
public class Acao extends Ativo {

    private SetorAcaoEnum segmentoAcao;

    public Acao(SetorAcaoEnum segmentoAcao) {
        super(TipoAtivoEnum.ACAO);
        this.segmentoAcao = segmentoAcao;
    }


}
