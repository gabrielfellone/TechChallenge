package com.example.tech.domain;

import com.example.tech.controller.resources.CarroRequest;
import com.example.tech.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carro {
    private UUID id;
    private String name;
    private String marca;
    private Locadora locadora;
    private Status disponibilidade;
    private Cliente cliente;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dtaLocacaoInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dtaLocacaoFinal;
    private String placa;


    public Carro(CarroRequest request){
        this.id = request.getId();
        this.placa = request.getPlaca();
        this.dtaLocacaoFinal = request.getDtaAluguelFinal();
        this.dtaLocacaoInicio = request.getDtaAluguelInicio();
        this.cliente = request.getCliente();


    }
}
