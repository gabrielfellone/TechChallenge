package com.example.tech.integration.notificacao;

import com.example.tech.domain.Carro;
import com.example.tech.domain.Locadora;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Notificacao {

    //Classe de exemplo para integracao com serviço de notificacao

    public void notificarLocadora(Locadora locadora, Carro carro){

        //aqui metodo para notificar locadora

        log.info("Locadora: {} - notificada sobre solicitacao de carro: {} para aluguel na data {} ate {}",
                locadora.getName(), carro.getPlaca(), carro.getDtaLocacaoInicio(), carro.getDtaLocacaoFinal());

    }

    public void notificarCliente(Locadora locadora, Carro carro){

        //aqui metodo para notificar cliente

        log.info("Cliente {} notificado sobre status de carro {} para aluguel na data {} ate {}",
                locadora.getName(), carro.getPlaca(), carro.getDtaLocacaoInicio(), carro.getDtaLocacaoFinal());

    }
}
