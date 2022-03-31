package br.com.stocksmaps.application.controllers;

import br.com.stocksmaps.application.dtos.inputModel.CarteiraInputModel;
import br.com.stocksmaps.application.dtos.viewModel.CarteiraViewModel;
import br.com.stocksmaps.application.useCases.CriarCarteiraUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/carteiras")
public class CarteiraController {

    private final CriarCarteiraUseCase criarCarteiraUseCase;

    @PostMapping
    public ResponseEntity<CarteiraViewModel> criar(@Valid @RequestBody CarteiraInputModel input) {

        //TODO construir factories e retorno da api
        final var response = this.criarCarteiraUseCase.execute(input);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }




}
