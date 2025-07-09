package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.jobfinder.entities.Curriculum;

import java.util.List;

@Repository
public interface ICurriculumRepository extends JpaRepository<Curriculum, Integer> {
    @Query(value = "SELECT u.id_usuario, u.nombre, u.apellido,\n" +
            "ROUND((COUNT(DISTINCT d.id_experiencia) * 0.4 + COUNT(DISTINCT d.id_estudio) * 0.3 +\n" +
            "COUNT(DISTINCT d.id_habilidad) * 0.2 + COUNT(DISTINCT d.id_certificado) * 0.1), 2) AS puntaje_absoluto,\n" +
            "ROUND(((COUNT(DISTINCT d.id_experiencia) * 0.4 + COUNT(DISTINCT d.id_estudio) * 0.3 +\n" +
            "COUNT(DISTINCT d.id_habilidad) * 0.2 + COUNT(DISTINCT d.id_certificado) * 0.1) / 5.4) * 100, 2) AS porcentaje_perfil\n" +
            "FROM users u\n" +
            "JOIN curriculum c ON u.id_usuario = c.id_usuario\n" +
            "JOIN detalle d ON c.id_curriculum = d.id_curriculum\n" +
            "GROUP BY u.id_usuario, u.nombre, u.apellido\n" +
            "ORDER BY porcentaje_perfil DESC",nativeQuery = true)
    public List<String[]> CurriculumByPromedio();
}
