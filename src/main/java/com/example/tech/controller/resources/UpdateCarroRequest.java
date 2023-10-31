package com.example.tech.controller.resources;

import com.example.tech.domain.Cliente;
import com.example.tech.domain.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UpdateCarroRequest {

    private UUID id;
    private Status status;
    
}
