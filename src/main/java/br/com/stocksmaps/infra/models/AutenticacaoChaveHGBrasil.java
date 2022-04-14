package br.com.stocksmaps.infra.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AutenticacaoChaveHGBrasil {

    @JsonProperty("valid_key")
    private Boolean valid;

}
