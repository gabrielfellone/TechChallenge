package com.example.tech.service;

import com.example.tech.controller.resources.CarroRequest;
import com.example.tech.controller.resources.UpdateCarroRequest;
import com.example.tech.domain.Carro;
import com.example.tech.domain.Cliente;
import com.example.tech.domain.Locadora;
import com.example.tech.domain.enums.Status;
import com.example.tech.integration.notificacao.Notificacao;
import com.example.tech.repository.CarroRepository;
import com.example.tech.repository.LocadoraRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LocadoraService {


    @Autowired
    private LocadoraRepository locadoraRepository;
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private Notificacao notificacao;

    public void notificaLocadoraAluguel(Carro carro) {
        log.info("Notificando Locadora para aval do carro alugado {} cliente {} com status de {}",
                carro.getPlaca(), carro.getCliente().getCpf(),carro.getDisponibilidade());

        Locadora locadora = locadoraRepository.getLocadoraById(carro.getLocadora().getId());

        log.info("Carro na locadora {}", locadora.getName());

        notificacao.notificarLocadora(locadora, carro);

    }

    public void alteraStatusCarro(UpdateCarroRequest request){
        Carro carro = carroRepository.getCarroById(request.getId());
        Locadora locadora = locadoraRepository.getLocadoraById(carro.getLocadora().getId());

        carro.setDisponibilidade(request.getStatus());
        notificacao.notificarCliente(locadora, carro);
    }

}
