package br.com.stocksmaps.infra.adapters.hgBrasil;

import br.com.stocksmaps.application.dtos.inputModel.AcaoInputModel;
import br.com.stocksmaps.application.dtos.inputModel.AutenticacaoChaveHGBrasilInputModel;
import br.com.stocksmaps.application.dtos.inputModel.FinancaInputModel;
import br.com.stocksmaps.core.httpClient.interfaces.IHttpClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IHGBrasilClient extends IHttpClient {

    @GetMapping
    ResponseEntity<AutenticacaoChaveHGBrasilInputModel> autenticarChave();

    @GetMapping
    ResponseEntity<FinancaInputModel> obterIndices();

    @GetMapping("/stock_price")
    ResponseEntity<AcaoInputModel> obterAtivo(@RequestParam(name = "symbol") String codigo);


}
