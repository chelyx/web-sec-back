package com.g5311.libretadigital.service;

import com.g5311.libretadigital.model.Curso;
import com.g5311.libretadigital.model.Nota;
import com.g5311.libretadigital.model.dto.NotaDto;
import com.g5311.libretadigital.model.dto.NotaResponse;
import com.g5311.libretadigital.repository.CursoRepository;
import com.g5311.libretadigital.repository.NotaRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;

    }

    public Nota guardarNota(NotaDto notaDto) {
        Nota nota = new Nota();
        nota.setCursoId(notaDto.idCurso);
        nota.setAlumnoAuth0Id(notaDto.idAlumno.toString());
        nota.setDescripcion(notaDto.descripcion);
        nota.setValor(notaDto.valor);

        return notaRepository.save(nota);
    }

    public Nota actualizarNota(Long id, NotaDto notaDto) {
        Nota nota = notaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nota no encontrada"));

        nota.setDescripcion(notaDto.descripcion);
        nota.setValor(notaDto.valor);

        return notaRepository.save(nota);
    }

    public List<NotaResponse> obtenerNotasDeCurso(Long cursoId) {
        return notaRepository.findNotaResponsesByCursoId(cursoId);
    }

    public Nota getNotaById(Long notaId) {
        return notaRepository.findById(notaId).orElse(null);
    }

    public List<Nota> obtenerNotasDeAlumno(Long cursoId, String alumnoAuth0Id) {
        return notaRepository.findByCursoIdAndAlumnoAuth0Id(cursoId, alumnoAuth0Id);
    }

    public List<Nota> guardarNotasEnBulk(Long cursoId, List<Nota> notas) {
        List<Nota> notasAGuardar = notas.stream()
                .map(n -> {
                    n.setCursoId(cursoId);
                    return n;
                })
                .collect(Collectors.toList());

        return notaRepository.saveAll(notasAGuardar);
    }

}
