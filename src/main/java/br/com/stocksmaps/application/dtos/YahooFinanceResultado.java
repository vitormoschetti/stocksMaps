package br.com.stocksmaps.application.dtos;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.Map;

@ToString
@NoArgsConstructor
public class YahooFinanceResultado {

    private Map<Long, YahooFinanceAtivoDTO> acoes;

    @JsonAnySetter
    public void put(Long key, YahooFinanceAtivoDTO value) {
        this.acoes = Collections.singletonMap(key, value);
    }

    @JsonAnyGetter
    public Map<Long, YahooFinanceAtivoDTO> getAcoes() {
        return this.acoes;
    }

}
