package com.example.tech.controller.resources;

import com.example.tech.domain.Carro;
import com.example.tech.domain.Locadora;
import com.example.tech.domain.enums.Status;
import lombok.Data;

import java.util.UUID;

@Data
public class CarroResource {

    private UUID id;
    private String placa;
    private String modelo;
    private String localizacao;
    private String dtaLocacaoInicio;
    private String dtaLocacaoFinal;
    private Status diponivel;
    private Locadora locadora;

    public CarroResource(Carro carro, String localizacao){
        this.id = carro.getId();
        this.placa = carro.getPlaca();
        this.modelo = carro.getMarca();
        this.localizacao = localizacao;
        this.dtaLocacaoInicio = getDtaLocacaoInicio();
        this.dtaLocacaoFinal = getDtaLocacaoFinal();
        this.diponivel = carro.getDisponibilidade();
        this.locadora = carro.getLocadora();

    }

}
