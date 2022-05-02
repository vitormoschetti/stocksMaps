package br.com.stocksmaps.infra.adapters.hgBrasil;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HgBrasilRequestInterceptor implements RequestInterceptor {

    private final String secret;

    public HgBrasilRequestInterceptor(@Value("${http.hgbrasil.secret}") String secret) {
        this.secret = secret;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.query("key", secret);
    }
}
