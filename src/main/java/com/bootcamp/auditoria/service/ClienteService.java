package com.bootcamp.auditoria.service;

import com.bootcamp.auditoria.dto.ClienteRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    public String registrarCliente(ClienteRequestDTO request){
        if (request.nombre().equalsIgnoreCase("error")){
            throw new IllegalArgumentException("Nombre invalido");
        }
        return "Cliente registrado: " + request.nombre();
    }
}
