package br.com.stocksmaps.application.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class YahooFinanceResponseDTO {

    @JsonProperty("result")
    private List<YahooFinanceResultado> resultado = new ArrayList<>();

}
