package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.jobfinder.entities.Curso;

import java.util.List;

public interface ICursoRepository extends JpaRepository<Curso, Integer> {
    @Query(value = "SELECT plataforma_curso, COUNT(*) AS totalCursos\n" +
            "FROM curso\n" +
            "GROUP BY plataforma_curso;",nativeQuery = true)
    public List<String[]> quantityCoursesByPlatform();
}
