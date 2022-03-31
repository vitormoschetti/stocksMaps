package br.com.stocksmaps.application.dtos.inputModel;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class CarteiraInputModel {

    @NotBlank
    @Size(min = 5, max = 20)
    private String nome;

}
