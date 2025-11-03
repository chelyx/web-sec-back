package com.g5311.libretadigital.model.dto;

import jakarta.validation.constraints.NotNull;

public class NotaDto {
    @NotNull(message = "El campo 'idCurso' no puede ser nulo")
    public Long idCurso;
    @NotNull(message = "El campo 'alumnoId' no puede ser nulo")
    public String idAlumno;
    @NotNull(message = "El campo 'valor' no puede ser nulo")
    public Double valor;
    public String descripcion;

    public NotaDto() {
    }
}
