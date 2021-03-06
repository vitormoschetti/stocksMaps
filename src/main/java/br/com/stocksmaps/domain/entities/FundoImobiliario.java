package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.application.dtos.inputModel.AcaoInputModel;
import lombok.Getter;

@Getter
public class FundoImobiliario extends Ativo {

    public void sincronizar(AcaoInputModel acaoInputModel) {
        final var dadosAcao = acaoInputModel.getAcao(this.getCodigo());
        this.atualizarPrecoAtual(dadosAcao.getPrecoAtual());
    }
}
