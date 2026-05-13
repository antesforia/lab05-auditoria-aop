package com.bootcamp.auditoria.dto;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDTO(
        @NotBlank (message = "El nombre no puede estar vacío")
        String nombre
) {
}
