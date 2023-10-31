package com.example.tech.repository;

import com.example.tech.domain.Carro;
import com.example.tech.domain.Locadora;
import com.example.tech.domain.enums.Status;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CarroRepository {
    //Aqui um exemplo de classe que no futuro pode ser uma interface que extende as entidades

    // Metodo para testes, nao vou entrar na funcionalidade de banco de dados
    public List<Carro> getCarrosPorLocalidade(String localizacao){


        List<Carro> carros = new ArrayList<>();
        Locadora locadora = new Locadora(UUID.randomUUID(),"Locadora Carro NOW","SaoPaulo", "Locadora Carro Now SA","locadora.carro.now@email.com","1321546654665" );

        Carro carro1 = new Carro(UUID.randomUUID(),"UNO", "FIAT",locadora, Status.DISPONIVEL, null, new Date(),new Date(),"DFD5465A");
        Carro carro2 = new Carro(UUID.randomUUID(),"RENEGADE", "JEEP",locadora, Status.DISPONIVEL, null, new Date(),new Date(),"GFFD5235A");
        Carro carro3 = new Carro(UUID.randomUUID(),"KWID", "RENAULT",locadora, Status.DISPONIVEL, null, new Date(),new Date(),"HRT3165A");
        Carro carro4 = new Carro(UUID.randomUUID(),"C3", "CITROEN",locadora, Status.DISPONIVEL, null, new Date(),new Date(),"GSDFG554A");
        Carro carro5 = new Carro(UUID.randomUUID(),"UP", "VW",locadora, Status.DISPONIVEL, null, new Date(),new Date(),"HDGDS544");
        Carro carro6 = new Carro(UUID.randomUUID(),"KWID", "RENAULT",locadora, Status.DISPONIVEL, null, new Date(),new Date(),"JKTY9789");


        carros.add(carro1);
        carros.add(carro2);
        carros.add(carro3);
        carros.add(carro4);
        carros.add(carro5);
        carros.add(carro6);

        return carros.stream().filter(carro -> carro.getLocadora().getLocalidade().contains(localizacao)).collect(Collectors.toList());


    }

    //Metedo simulando get by id Carro
    public Carro getCarroById(UUID id){
        Locadora locadora = new Locadora(UUID.randomUUID(),"Locadora Carro NOW","SaoPaulo", "Locadora Carro Now SA","locadora.carro.now@email.com","1321546654665" );
        return new Carro(UUID.randomUUID(),"KWID", "RENAULT",locadora, Status.DISPONIVEL, null, new Date(),new Date(),"JKTY9789");
    }


}
