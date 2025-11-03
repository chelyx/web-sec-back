package com.g5311.libretadigital.controller;

import com.g5311.libretadigital.model.Nota;
import com.g5311.libretadigital.model.dto.NotaDto;
import com.g5311.libretadigital.model.dto.NotaResponse;
import com.g5311.libretadigital.service.NotaService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    // // Cargar una nota
    // @PostMapping("/curso/{cursoId}")
    // public Nota guardarNota(
    // @PathVariable Long cursoId,
    // @RequestBody Map<String, Object> body) {
    // String alumnoAuth0Id = (String) body.get("alumnoAuth0Id");
    // String descripcion = (String) body.get("descripcion");
    // Double valor = ((Number) body.get("valor")).doubleValue();

    // return notaService.guardarNota(cursoId, alumnoAuth0Id, descripcion, valor);
    // }

    // Obtener todas las notas de un curso
    // @GetMapping("/curso/{cursoId}")
    // public List<NotaResponse> obtenerNotasDeCurso(@PathVariable Long cursoId) {
    // return notaService.obtenerNotasDeCurso(cursoId);
    // }

    // Endpoint vulnerable: listar notas por query param 'curso' sin verificar
    // permisos del profesor
    // EJEMPLO MALICIOSO: GET /api/notas?curso=2
    @GetMapping
    public List<NotaResponse> obtenerNotasPorQuery(@RequestParam(name = "curso") Long cursoId) {
        return notaService.obtenerNotasDeCurso(cursoId);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Nota> updateNotas(@RequestParam(name = "nota") Long notaId,
            @Valid @RequestBody NotaDto entity) {

        Nota nota = notaService.actualizarNota(notaId, entity);
        return ResponseEntity.ok(nota);
    }

    // Obtener las notas de un alumno en un curso
    @GetMapping("/curso/{cursoId}/alumno/{auth0Id}")
    public List<Nota> obtenerNotasDeAlumno(
            @PathVariable Long cursoId,
            @PathVariable String auth0Id) {
        return notaService.obtenerNotasDeAlumno(cursoId, auth0Id);
    }

    @PostMapping("/curso/{cursoId}/bulk")
    public List<Nota> guardarNotasEnBulk(
            @PathVariable Long cursoId,
            @RequestBody List<Map<String, Object>> notasData) {
        List<Nota> notas = notasData.stream().map(data -> {
            Nota n = new Nota();
            n.setAlumnoAuth0Id((String) data.get("alumnoAuth0Id"));
            n.setDescripcion((String) data.get("descripcion"));
            n.setValor(((Number) data.get("valor")).doubleValue());
            return n;
        }).toList();

        return notaService.guardarNotasEnBulk(cursoId, notas);
    }
}
