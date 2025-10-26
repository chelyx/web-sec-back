package com.g5311.libretadigital.service;

import com.g5311.libretadigital.model.Curso;
import com.g5311.libretadigital.model.Nota;
import com.g5311.libretadigital.repository.CursoRepository;
import com.g5311.libretadigital.repository.NotaRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotaService {

    private final NotaRepository notaRepository;
    private final CursoRepository cursoRepository;

    public NotaService(NotaRepository notaRepository, CursoRepository cursoRepository) {
        this.notaRepository = notaRepository;
        this.cursoRepository = cursoRepository;
    }

    public Nota guardarNota(Long cursoId, String alumnoAuth0Id, String descripcion, Double valor) {
        Nota nota = new Nota();
        nota.setCurso(cursoId);
        nota.setAlumnoAuth0Id(alumnoAuth0Id);
        nota.setDescripcion(descripcion);
        nota.setValor(valor);

        return notaRepository.save(nota);
    }

    public List<Nota> obtenerNotasDeCurso(Long cursoId) {
        return notaRepository.findByCursoId(cursoId);
    }

    public List<Nota> obtenerNotasDeAlumno(Long cursoId, String alumnoAuth0Id) {
        return notaRepository.findByCursoIdAndAlumnoAuth0Id(cursoId, alumnoAuth0Id);
    }

    public List<Nota> guardarNotasEnBulk(Long cursoId, List<Nota> notas) {
        List<Nota> notasAGuardar = notas.stream()
                .map(n -> {
                    n.setCurso(cursoId);
                    return n;
                })
                .collect(Collectors.toList());

        return notaRepository.saveAll(notasAGuardar);
    }

}
