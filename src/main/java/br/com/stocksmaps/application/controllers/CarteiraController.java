package br.com.stocksmaps.application.controllers;

import br.com.stocksmaps.application.dtos.inputModel.CarteiraInputModel;
import br.com.stocksmaps.application.dtos.viewModel.CarteiraViewModel;
import br.com.stocksmaps.application.useCases.CriarCarteiraUseCase;
import br.com.stocksmaps.application.useCases.SincronizarCarteiraUseCase;
import br.com.stocksmaps.infra.adapters.HGBrasilHttpClient;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/carteiras")
public class CarteiraController {

    private final CriarCarteiraUseCase criarCarteiraUseCase;
    private final SincronizarCarteiraUseCase sincronizarCarteiraUseCase;
    private final HGBrasilHttpClient client;

    @PostMapping
    public ResponseEntity<CarteiraViewModel> criar(@Valid @RequestBody CarteiraInputModel input) {

        //TODO construir factories e retorno da api
        final var response = this.criarCarteiraUseCase.execute(input);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PostMapping("{id}/sincronizar")
    public void sincronizarCarteira(@PathVariable Long id){
        this.sincronizarCarteiraUseCase.execute(id);
    }


    @GetMapping
    public void teste(){
        this.client.autenticarChave();
        this.client.obterIndices();
        this.client.obterAtivo("ITUB4");
    }

}
