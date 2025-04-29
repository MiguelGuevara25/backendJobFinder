package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.jobfinder.entities.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Integer> {
}
