package com.example.tech.integration.googleMaps;

import com.example.tech.exception.GoogleMapsException;
import com.example.tech.properties.GoogleMapsProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GoogleMapsClient {

    private GoogleMapsProperties properties;

    // Client para usar a API do Google Maps

    public String verificarLocalizacaoEstado(String localizacao) {

        log.info("Localizacao get Google API: ", localizacao);

        return SDKGoogleAPI(localizacao);

    }

    public String SDKGoogleAPI(String localizacao){
        //Aqui faz a logica para bater na API do Google
        //Apenas para simular um teste, pois nao entrarei neste processo de API externa

        log.info(localizacao);

        if (localizacao.equals("SaoPaulo")) {
            return "SaoPaulo";
        } else {
            throw  new GoogleMapsException("Carro nao localizado para essa regiao");
        }

    }

}
