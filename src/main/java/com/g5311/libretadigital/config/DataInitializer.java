package com.g5311.libretadigital.config;

import com.g5311.libretadigital.model.Curso;
import com.g5311.libretadigital.model.Nota;
import com.g5311.libretadigital.model.User;
import com.g5311.libretadigital.repository.CursoRepository;
import com.g5311.libretadigital.repository.NotaRepository;
import com.g5311.libretadigital.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Set;

@Component
public class DataInitializer {

        private final CursoRepository cursoRepository;
        private final UserRepository userRepository;
        private final NotaRepository notaRepository;

        public DataInitializer(CursoRepository cursoRepository,
                        UserRepository userRepository,
                        NotaRepository notaRepository) {
                this.cursoRepository = cursoRepository;
                this.userRepository = userRepository;
                this.notaRepository = notaRepository;
        }

        @PostConstruct
        public void init() {
                if (cursoRepository.count() > 0)
                        return;

                // 👩‍🏫 Profesores
                User prof1 = new User();
                prof1.setAuth0Id("auth0|68bc93d0f21d782f04f36998");
                prof1.setNombre("Profesor Uno");
                prof1.setEmail("prof1@utn.edu.ar");
                prof1.setRol("PROFESOR");

                User prof2 = new User();
                prof2.setAuth0Id("auth0|prof456");
                prof2.setNombre("Profesor Dos");
                prof2.setEmail("prof2@utn.edu.ar");
                prof2.setRol("PROFESOR");

                userRepository.saveAll(List.of(prof1, prof2));

                // 👨‍🎓 Alumnos
                User a1 = new User();
                a1.setAuth0Id("auth0|alum1");
                a1.setNombre("Juan Pérez");
                a1.setEmail("juan@utn.edu.ar");
                a1.setRol("ALUMNO");

                User a2 = new User();
                a2.setAuth0Id("auth0|alum2");
                a2.setNombre("María Gómez");
                a2.setEmail("maria@utn.edu.ar");
                a2.setRol("ALUMNO");

                User a3 = new User();
                a3.setAuth0Id("auth0|alum3");
                a3.setNombre("Pedro López");
                a3.setEmail("pedro@utn.edu.ar");
                a3.setRol("ALUMNO");

                User a4 = new User();
                a4.setAuth0Id("auth0|alum4");
                a4.setNombre("Yasmin Elias");
                a4.setEmail("yasmin@utn.edu.ar");
                a4.setRol("ALUMNO");

                User a5 = new User();
                a5.setAuth0Id("auth0|alum5");
                a5.setNombre("Cecilia Rocca");
                a5.setEmail("cecilia@utn.edu.ar");
                a5.setRol("ALUMNO");

                userRepository.saveAll(List.of(a1, a2, a3, a4, a5));

                // 📘 Cursos
                Curso curso1 = new Curso();
                curso1.setNombre("Programación I");
                curso1.setCodigo("PROG1");
                curso1.setDocenteAuth0Id(prof1.getAuth0Id());
                curso1.setAlumnos(Set.of(a1, a2, a3)); // usamos List<User>

                Curso curso2 = new Curso();
                curso2.setNombre("Bases de Datos");
                curso2.setCodigo("BD2024");
                curso2.setDocenteAuth0Id(prof2.getAuth0Id());
                curso2.setAlumnos(Set.of(a1, a2, a5));

                Curso curso3 = new Curso();
                curso3.setNombre("Bioinformatica - Electiva");
                curso3.setCodigo("K5055");
                curso3.setDocenteAuth0Id(prof2.getAuth0Id());
                curso3.setAlumnos(Set.of(a1, a4, a5));

                cursoRepository.saveAll(List.of(curso1, curso2, curso3));

                // 🧮 Notas de ejemplo
                Nota n1 = new Nota();
                n1.setCursoId(curso1.getId());
                n1.setAlumnoAuth0Id(a1.getAuth0Id());
                n1.setDescripcion("Parcial 1");
                n1.setValor(8.0);

                Nota n2 = new Nota();
                n2.setCursoId(curso1.getId());
                n2.setAlumnoAuth0Id(a2.getAuth0Id());
                n2.setDescripcion("Parcial 1");
                n2.setValor(6.5);

                Nota n3 = new Nota();
                n3.setCursoId(curso1.getId());
                n3.setAlumnoAuth0Id(a3.getAuth0Id());
                n3.setDescripcion("Parcial 1");
                n3.setValor(9.0);

                Nota n4 = new Nota();
                n4.setCursoId(curso2.getId());
                n4.setAlumnoAuth0Id(a1.getAuth0Id());
                n4.setDescripcion("TP 1");
                n4.setValor(7.5);

                Nota n5 = new Nota();
                n5.setCursoId(curso3.getId());
                n5.setAlumnoAuth0Id(a5.getAuth0Id());
                n5.setDescripcion("Final");
                n5.setValor(5.0);

                notaRepository.saveAll(List.of(n1, n2, n3, n4, n5));

                System.out.println("✅ Datos iniciales cargados correctamente");
        }
}
