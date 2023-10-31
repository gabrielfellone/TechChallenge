package com.example.tech.controller;

import com.example.tech.controller.resources.UpdateCarroRequest;
import com.example.tech.service.LocadoraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.noContent;

@Slf4j
@RestController
@RequestMapping("/v1/locadora")
@RequiredArgsConstructor
public class LocadoraController {

    @Autowired
    LocadoraService locadoraService;
    @PutMapping("status")
    public ResponseEntity<Void> updateStatusCarro(@RequestBody UpdateCarroRequest request) {
        log.info("Altera status de disponibilidade do carro {}", request);
        locadoraService.alteraStatusCarro(request);
        return noContent().build();
    }

}
