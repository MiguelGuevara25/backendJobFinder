package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.jobfinder.entities.Experiencia;

import java.util.List;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Integer> {
    //1. Este query calcula cuánto tiempo (en promedio) ha durado cada puesto de trabajo
    // en los registros de experiencia laboral.
    //2. Te dice qué puestos suelen durar más tiempo, lo cual puede reflejar estabilidad
    // laboral, madurez del cargo o nivel jerárquico.
    @Query(value = "SELECT\n" +
            "    job,\n" +
            "    AVG( (end_date - start_date) / (365.25 / 12.0) ) AS duracion_promedio_meses\n" +
            "FROM\n" +
            "    experiencia\n" +
            "WHERE\n" +
            "    end_date IS NOT NULL AND    \n" +
            "    start_date IS NOT NULL AND    \n" +
            "    end_date >= start_date      \n" +
            "GROUP BY\n" +
            "    job\n" +
            "ORDER BY\n" +
            "    duracion_promedio_meses DESC;",nativeQuery = true)
    public List<String[]> DuracionPromedioPorPuesto();

    //1. Este query cuenta cuántas experiencias laborales tiene cada usuario.
    //2. Identifica si los usuarios tienen perfiles junior, intermedios o senior.
    @Query(value = "SELECT \n" +
            "    c.id_usuario, \n" +
            "    COUNT(*) AS cantidad_experiencias\n" +
            "FROM curriculum c\n" +
            "JOIN detalle d ON c.id_curriculum = d.id_curriculum\n" +
            "WHERE d.id_experiencia IS NOT NULL\n" +
            "GROUP BY c.id_usuario\n" +
            "ORDER BY cantidad_experiencias DESC;",nativeQuery = true)
    public List<String[]> PromedioExperienciaLaboral();
}
