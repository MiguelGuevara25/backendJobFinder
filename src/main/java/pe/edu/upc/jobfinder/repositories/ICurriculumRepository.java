package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.jobfinder.entities.Curriculum;

import java.util.List;

@Repository
public interface ICurriculumRepository extends JpaRepository<Curriculum, Integer> {
    @Query(value = "SELECT\n" +
            " u.id_usuario,\n" +
            " u.nombre,\n" +
            " u.apellido,\n" +
            " COUNT(DISTINCT d.id) AS total_experiencias,\n" +
            " COUNT(DISTINCT d.id_estudio) AS total_estudios,\n" +
            " COUNT(DISTINCT d.id_habilidad) AS total_habilidades,\n" +
            " COUNT(DISTINCT d.id_certificado) AS total_certificados,\n" +
            " ROUND((COUNT(DISTINCT d.id_experiencia) * 0.4 +\n" +
            " COUNT(DISTINCT d.id_estudio) * 0.3 +\n" +
            " COUNT(DISTINCT d.id_habilidad) * 0.2 +\n" +
            " COUNT(DISTINCT d.id_certificado) * 0.1\n" +
            " ), 2) AS puntaje_ponderado\n" +
            " FROM users u\n" +
            " JOIN curriculum c ON u.id_usuario = c.id_usuario\n" +
            " JOIN detalle d ON c.id_curriculum = d.id\n" +
            " GROUP BY u.id_usuario, u.nombre, u.apellido\n" +
            " ORDER BY puntaje_ponderado DESC",nativeQuery = true)
    public List<String[]> CurriculumByPromedio();
}
