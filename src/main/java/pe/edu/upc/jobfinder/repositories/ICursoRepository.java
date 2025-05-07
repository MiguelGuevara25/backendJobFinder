package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Curso;

import java.util.List;

public interface ICursoRepository extends JpaRepository<Curso, Integer> {
    @Query(value = "SELECT plataforma_curso, COUNT(*) AS totalCursos\n" +
            " FROM curso\n" +
            " GROUP BY plataforma_curso;",nativeQuery = true)
    public List<String[]> quantityCoursesByPlatform();
    @Query(value = "SELECT e.namecompany AS empresa, COUNT(c.id_curso) AS total_cursos\n" +
            "FROM empresa e\n" +
            "LEFT JOIN curso c ON e.id = c.id_empresa\n" +
            "GROUP BY e.namecompany\n" +
            "ORDER BY total_cursos DESC;",nativeQuery = true)
    public List<String[]> quantityCoursesByEnterprise();
}
