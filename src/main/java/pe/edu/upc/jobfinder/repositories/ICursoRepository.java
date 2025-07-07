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

    @Query(value = "SELECT e.nameCompany AS empresa, COUNT(c.id_curso) AS totalCursos\n" +
            "FROM curso c\n" +
            "JOIN empresa e ON c.id_empresa = e.id\n" +
            "GROUP BY e.nameCompany;",nativeQuery = true)
    public List<String[]> quantityCoursesByEnterprise();
}
