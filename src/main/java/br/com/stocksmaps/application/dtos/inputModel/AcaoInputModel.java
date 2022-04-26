package br.com.stocksmaps.application.dtos.inputModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class AcaoInputModel {

    @JsonProperty("results")
    private ResultadoInputModel resultados;

    public DadosAcaoInputModel getAcao(String codigo) {
        return this.resultados.getAcoes().get(codigo);
    }

}

