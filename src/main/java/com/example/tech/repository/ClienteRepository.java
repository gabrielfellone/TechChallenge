package com.example.tech.repository;

import com.example.tech.domain.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ClienteRepository {
    //Aqui um exemplo de classe que no futuro pode ser uma interface que extende as entidades


    //Exemplo de integracao com banco de dados getbyid

    public Cliente findById(UUID id){
        return new Cliente(UUID.fromString("edf6cdf3-ddbd-4525-95f1-3721ba0467f5"), "Antonio Manuel", "SaoPaulo", "antonio.manuel@email.com.br", "54645678141" );
    }

    //Exemplo de integracao com banco de dados find all
    public List<Cliente> findAll(){

        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente(UUID.fromString("edf6cdf3-ddbd-4525-95f1-3721ba0467f5"), "Antonio Manuel", "SaoPaulo", "antonio.manuel@email.com.br", "54645678141" );
        Cliente cliente2 = new Cliente(UUID.randomUUID(), "Rodrigo Baz", "SaoPaulo", "rodrigo.baz@email.com.br", "456489498" );
        Cliente cliente3 = new Cliente(UUID.randomUUID(), "Matilda Alvez", "SaoPaulo", "matilda.alvez@email.com.br", "78974894181" );
        Cliente cliente4 = new Cliente(UUID.randomUUID(), "Carlos Roberto", "SaoPaulo", "carlos.roberto@email.com.br", "321312412" );
        Cliente cliente5 = new Cliente(UUID.randomUUID(), "Fernando Pintor", "SaoPaulo", "fernando.pintor@email.com.br", "5451489498" );

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);

        return clientes;

    }

}
