package br.com.stocksmaps.application.dtos.inputModel;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

@Getter
@ToString
@NoArgsConstructor
public class AcaoInputModel {

    @JsonProperty("results")
    private ResultadoInputModel resultados;

}

@Getter
@ToString
@NoArgsConstructor
class ResultadoInputModel {

    private Map<String, DadosAcaoInputModel> acao;

    @JsonAnySetter
    public void put(String key, DadosAcaoInputModel value) {
        this.acao = Collections.singletonMap(key, value);
    }

    @JsonAnyGetter
    public Map<String, DadosAcaoInputModel> getValues() {
        return this.acao;
    }

}

@Getter
@ToString
@NoArgsConstructor
class DadosAcaoInputModel {

    @JsonProperty("symbol")
    private String codigo;

    @JsonProperty("name")
    private String nome;

    @JsonProperty("website")
    private String siteRI;

    @JsonProperty("price")
    private BigDecimal preco;

    @JsonProperty("change_percent")
    private BigDecimal variacao;

}