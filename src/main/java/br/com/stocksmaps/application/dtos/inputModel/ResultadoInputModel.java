package br.com.stocksmaps.application.dtos.inputModel;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.Map;

@ToString
@NoArgsConstructor
public class ResultadoInputModel {

    private Map<String, DadosAcaoInputModel> acoes;

    @JsonAnySetter
    public void put(String key, DadosAcaoInputModel value) {
        this.acoes = Collections.singletonMap(key, value);
    }

    @JsonAnyGetter
    public Map<String, DadosAcaoInputModel> getAcoes() {
        return this.acoes;
    }

}
