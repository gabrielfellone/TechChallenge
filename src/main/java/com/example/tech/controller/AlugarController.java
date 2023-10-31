package com.example.tech.controller;


import com.example.tech.controller.resources.CarroRequest;
import com.example.tech.controller.resources.CarroResource;
import com.example.tech.controller.resources.UpdateCarroRequest;
import com.example.tech.service.AlugarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.noContent;

@Slf4j
@RestController
@RequestMapping("/v1/alugar")
@RequiredArgsConstructor
public class AlugarController {

    private final AlugarService alugarService;

    @GetMapping("listaCarros")
    public ResponseEntity<List<CarroResource>> getListaCarros(@RequestParam(value = "localizacao", required = true) String localizacao){
        log.info("Busca Lista de Carros na Proximidade do Usuario");
        return ResponseEntity.ok(alugarService.getListaCarros(localizacao));
    }

    @PostMapping("alugar")
    public ResponseEntity<String> postAlugaCarro(@RequestBody CarroRequest request) {
        log.info("Solicitado carro para alugar {}", request);
        alugarService.alugaCarro(request);
        return ResponseEntity.status(CREATED).body("Pedido de aluguel realizado com sucesso!");
    }

    @PutMapping("devolucao")
    public ResponseEntity<Void> notificaDevolucaoCarro(@RequestBody UpdateCarroRequest request) {
        alugarService.notificaDevolucao(request);
        return noContent().build();
    }

    @PostMapping("extensao")
    public ResponseEntity<String> extenderPrazo(@RequestBody CarroRequest request) {
        log.info("Solicitado extensao prazo de aluguel {}", request);
        alugarService.extenderAluguel(request);
        return ResponseEntity.status(CREATED).body("Extensao solicitada com sucesso!");
    }



}
