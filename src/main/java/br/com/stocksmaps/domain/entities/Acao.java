package br.com.stocksmaps.domain.entities;

import br.com.stocksmaps.application.dtos.inputModel.AcaoInputModel;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Acao extends Ativo {

    public void sincronizar(AcaoInputModel acaoInputModel) {
        final var dadosAcao = acaoInputModel.getAcao(this.getCodigo());
        this.atualizarPrecoAtual(dadosAcao.getPrecoAtual());
    }
}
