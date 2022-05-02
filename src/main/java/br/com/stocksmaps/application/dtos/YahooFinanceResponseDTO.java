package br.com.stocksmaps.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class YahooFinanceResponseDTO {

    @JsonProperty("result")
    private List<YahooFinanceResultado> resultado;

}
