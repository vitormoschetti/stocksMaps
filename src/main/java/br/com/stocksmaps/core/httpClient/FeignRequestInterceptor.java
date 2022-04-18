package br.com.stocksmaps.core.httpClient;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    private String secret;

    public FeignRequestInterceptor(@Value("${secret.hgbrasil}") String secret) {
        this.secret = secret;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.query("key", secret);
    }
}
