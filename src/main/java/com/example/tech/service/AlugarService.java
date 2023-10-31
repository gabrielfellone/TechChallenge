package com.example.tech.service;

import com.example.tech.controller.resources.CarroRequest;
import com.example.tech.controller.resources.CarroResource;
import com.example.tech.controller.resources.UpdateCarroRequest;
import com.example.tech.domain.Carro;
import com.example.tech.domain.Cliente;
import com.example.tech.domain.enums.Status;
import com.example.tech.exception.AluguelCarroException;
import com.example.tech.exception.GoogleMapsException;
import com.example.tech.integration.googleMaps.GoogleMaps;
import com.example.tech.repository.CarroRepository;
import com.example.tech.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Slf4j
@RequiredArgsConstructor
@Service
public class AlugarService {

    private final GoogleMaps maps;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private LocadoraService locadoraService;

    public List<CarroResource> getListaCarros(String localizacao) {
        log.info("Recuperando Carros Disponiveis nas Proximidades do Usuarios: {}", localizacao);
        try {
            return maps.getLocalizacao(localizacao);
        } catch (GoogleMapsException e) {
            throw new GoogleMapsException("Erro para localizar carros no Google Maps", e);
        }
    }

    public void alugaCarro(CarroRequest request) {
        log.info("Solicitando aluguel de carro {}", request.getPlaca());
        Cliente cliente = getCliente(request.getCliente().getId());
        Carro carro = getCarro(request.getId());
        carro.setCliente(cliente);
        solicitaAluguelCarro(cliente, request, carro);

    }

    public boolean validaDisponibilidade(Carro carro, CarroRequest carroRequest) {

        if (carro.getDisponibilidade().equals(Status.DISPONIVEL)) {
            if (carro.getDtaLocacaoFinal().after(carroRequest.getDtaAluguelInicio())) {
                log.info("Verificar se carro esta disponivel e se data de inicio do aluguel maior que final atual");

                return true;

            }

        }
        return false;
    }

    public void notificaDevolucao(UpdateCarroRequest request) {
        log.info("Cliente Notifica a devolucao do carro para locadora dar aval {}", request);
        Carro carro = getCarro(request.getId());
        Cliente cliente = getCliente(carro.getId());
        carro.setCliente(cliente);
        locadoraService.notificaLocadoraAluguel(carro);

    }

    public Cliente getCliente(UUID id) {
        Cliente cliente = clienteRepository.findById(id);
        if (nonNull(cliente)) {
            return cliente;
        } else {
            throw new AluguelCarroException("Erro ao buscar cliente na base: " + id);
        }
    }

    public void extenderAluguel(CarroRequest request) {
        log.info("Solicitando extensao aluguel de carro {}", request.getPlaca());

        Cliente cliente = getCliente(request.getCliente().getId());
        Carro carro = getCarro(request.getId());

        log.info("Verificando se o mesmo cliente {} solicitou a extensao do carro {}",
                request.getCliente().getName(), carro.getPlaca());

        if(nonNull(carro.getCliente())){
            if (carro.getCliente().getId().equals(request.getCliente().getId())) {
                solicitaAluguelCarro(cliente, request, carro);
            } else {
                throw new AluguelCarroException("Solicitacao de extensao de prazo nao esta associado ao mesmo cliente");
            }
        } else {
            log.info("Carro sem cliente associado");
            solicitaAluguelCarro(cliente, request, carro);
        }
    }

    public Carro getCarro(UUID id) {
        Carro carro = carroRepository.getCarroById(id);
        if (nonNull(carro)) {
            return carro;
        } else {
            throw new AluguelCarroException("Erro ao buscar carro na base: " + id);
        }
    }


    public void solicitaAluguelCarro(Cliente cliente, CarroRequest request, Carro carro) {
        try {

            //Mock para teste adicionando data inicio maior
            carro.getDtaLocacaoInicio().setTime(1000);

            if (validaDisponibilidade(carro, request)) {
                log.info("Carro disponivel para alugar {}", carro.getPlaca());

                carro.setDtaLocacaoInicio(request.getDtaAluguelInicio());
                carro.setDtaLocacaoFinal(request.getDtaAluguelFinal());
                carro.setCliente(cliente);

                locadoraService.notificaLocadoraAluguel(carro);

            }

        } catch (AluguelCarroException e) {
            throw new AluguelCarroException("Não foi possivel solicitar aluguel do veiculo", e);
        }
    }


}
