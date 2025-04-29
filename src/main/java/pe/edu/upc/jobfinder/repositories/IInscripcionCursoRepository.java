package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.jobfinder.entities.InscripcionCurso;

public interface IInscripcionCursoRepository extends JpaRepository<InscripcionCurso, Integer> {
}
