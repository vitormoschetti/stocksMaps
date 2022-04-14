package br.com.stocksmaps.infra.adapters;

import br.com.stocksmaps.core.httpClient.interfaces.IHttpClient;
import br.com.stocksmaps.infra.models.AutenticacaoChaveHGBrasil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IHGBrasilClient extends IHttpClient {

    @GetMapping
    ResponseEntity<AutenticacaoChaveHGBrasil> autenticarChave(@RequestParam("key") String key);

}
