package com.bootcamp.auditoria.controller;

import com.bootcamp.auditoria.dto.ClienteRequestDTO;
import com.bootcamp.auditoria.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public String registrar(
            @Valid @RequestBody ClienteRequestDTO request
            ){
        return clienteService.registrarCliente(request);
    }
}
