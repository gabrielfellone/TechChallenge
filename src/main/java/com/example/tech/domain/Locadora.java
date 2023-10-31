package com.example.tech.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Locadora {

    private UUID id;
    private String name;
    private String localidade;
    private String dono;
    private String email;
    private String cnpj;

}
