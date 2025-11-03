package com.g5311.libretadigital.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "notas")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "curso_id", nullable = false)
    private Long cursoId;

    @Column(name = "alumno_auth0_id", nullable = false)
    private String alumnoAuth0Id;

    private String descripcion; // Ej: "Parcial 1", "TP 2", "Final"

    private Double valor; // Ej: 8.5

    private Date fecha = new Date();

    // --- Getters y Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long curso) {
        this.cursoId = curso;
    }

    public String getAlumnoAuth0Id() {
        return alumnoAuth0Id;
    }

    public void setAlumnoAuth0Id(String alumnoAuth0Id) {
        this.alumnoAuth0Id = alumnoAuth0Id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}