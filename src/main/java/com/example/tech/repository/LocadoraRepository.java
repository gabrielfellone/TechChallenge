package com.example.tech.repository;

import com.example.tech.domain.Locadora;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class LocadoraRepository {
    //Aqui um exemplo de classe que no futuro pode ser uma interface que extende as entidades


     //Exemplo de metodo get by id locadora no banco de dados

    public Locadora getLocadoraById(UUID id){
        return new Locadora(UUID.randomUUID(),"CarroNOW","SaoPaulo", "Locadora Carro Now SA","locadora.carro.now@email.com","1321546654665" );
    }

}
