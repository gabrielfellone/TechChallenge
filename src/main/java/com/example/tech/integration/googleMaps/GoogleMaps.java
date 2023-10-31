package com.example.tech.integration.googleMaps;

import com.example.tech.controller.resources.CarroResource;
import com.example.tech.domain.Carro;
import com.example.tech.exception.GoogleMapsException;
import com.example.tech.repository.CarroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GoogleMaps {

    //Classe de Servico para Usar o Google Maps
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private GoogleMapsClient mapsClient;

    public List<CarroResource> getLocalizacao(String localizacao) throws GoogleMapsException {

        log.info("Get Localizacao {}", localizacao );

        String getClient = mapsClient.verificarLocalizacaoEstado(localizacao);

        log.info("Retorno Client Google Maps {}", getClient );

        List<Carro> carros = carroRepository.getCarrosPorLocalidade(getClient);

        List<CarroResource> resources = new ArrayList<>();

        if(carros.isEmpty()){ throw new GoogleMapsException("Lista de Carros Vazia");}

        carros.forEach(e -> {
            resources.add(new CarroResource(e, localizacao));
        });

        return resources;

    }



}
