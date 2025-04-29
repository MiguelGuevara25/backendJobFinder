package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.jobfinder.entities.InscripcionCurso;

import java.util.List;

public interface IInscripcionCursoRepository extends JpaRepository<InscripcionCurso, Integer> {
    @Query(value = "SELECT c.titulo_curso, COUNT(*) AS total_inscripciones\n" +
            "FROM inscripcion_curso ic\n" +
            "JOIN curso c ON ic.id_curso = c.id_curso\n" +
            "GROUP BY c.titulo_curso;",nativeQuery = true)
    public List<String[]> totalRegistrationByCourse();
    @Query(value = "SELECT c.titulo_curso, AVG(CAST(ic.progreso_inscripcion_curso AS INTEGER)) AS promedio_progreso\n" +
            "FROM inscripcion_curso ic\n" +
            "JOIN curso c ON ic.id_curso = c.id_curso\n" +
            "GROUP BY c.titulo_curso;",nativeQuery = true)
    public List<String[]> promedioDeCursos();
}
