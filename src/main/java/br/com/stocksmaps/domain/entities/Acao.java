package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.application.dtos.inputModel.AcaoInputModel;
import lombok.Getter;

@Getter
public class Acao extends Ativo {

    @Override
    protected void validar() {
    }

    public void sincronizar(AcaoInputModel acaoInputModel) {
        final var dadosAcao = acaoInputModel.getAcao(this.getCodigo());
        this.atualizarPrecoAtual(dadosAcao.getPrecoAtual());
    }
}
