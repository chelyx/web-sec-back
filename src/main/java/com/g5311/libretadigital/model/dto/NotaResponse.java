package com.g5311.libretadigital.model.dto;

import java.util.Date;

public class NotaResponse {

    private Long id;
    private Long cursoId;
    private Date fecha;
    private String alumnoId;
    private String alumnoNombre;
    private String descripcion;
    private Double valor;

    // 👇 Constructor usado por el JPQL
    public NotaResponse(Long id, Long cursoId, Date fecha, String auth0Id, String nombre, Double valor,
            String descripcion) {
        this.id = id;
        this.cursoId = cursoId;
        this.fecha = fecha;
        this.alumnoId = auth0Id;
        this.alumnoNombre = nombre;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getAlumnoNombre() {
        return alumnoNombre;
    }

    public void setAlumnoNombre(String alumnoNombre) {
        this.alumnoNombre = alumnoNombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}