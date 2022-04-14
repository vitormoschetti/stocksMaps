package br.com.stocksmaps.infra.adapters;

import br.com.stocksmaps.core.httpClient.BaseFeign;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.stereotype.Component;

@Component
public class HGBrasilHttpClient extends BaseFeign<IHGBrasilClient> {

    private String secret;

    public HGBrasilHttpClient(@Value("${http.hgbrasil}") String host,
                              @Value("${secret.hgbrasil}") String secret,
                              final ResponseEntityDecoder decoder,
                              final Encoder encoder) {
        super(host, IHGBrasilClient.class, decoder, encoder);
        this.secret = secret;
    }

    public Boolean autenticarChave() {
        final var response = this.client.autenticarChave(secret);
        return response.getBody().getValid();
    }


}
