package com.g5311.libretadigital.repository;

import com.g5311.libretadigital.model.Nota;
import com.g5311.libretadigital.model.dto.NotaResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    List<Nota> findByCursoId(Long cursoId);

    List<Nota> findByCursoIdAndAlumnoAuth0Id(Long cursoId, String alumnoAuth0Id);

    @Query("select new com.g5311.libretadigital.model.dto.NotaResponse(a.id,a.cursoId, a.fecha, u.nombre, a.valor, a.descripcion) "
            + "from Nota a join com.g5311.libretadigital.model.User u on a.alumnoAuth0Id = u.auth0Id "
            + "where a.cursoId = :cursoId")
    List<NotaResponse> findNotaResponsesByCursoId(@Param("cursoId") Long cursoId);
}
