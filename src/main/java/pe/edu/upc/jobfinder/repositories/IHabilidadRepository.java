package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.jobfinder.entities.Habilidad;

import java.util.List;

@Repository
public interface IHabilidadRepository extends JpaRepository<Habilidad, Integer> {
    //1.Este query busca cuántos usuarios tienen cada habilidad registrada en sus currículums.
    //2.Detectar si hay brechas de habilidades (lo que poca gente sabe).
    @Query(value = "SELECT h.nombre, COUNT(*) AS cantidad_usuarios\n" +
            " FROM habilidad h\n" +
            " INNER JOIN detalle d ON h.id_habilidad = d.id_habilidad\n" +
            " INNER JOIN curriculum c ON d.id_curriculum = c.id_curriculum\n" +
            " GROUP BY h.nombre\n" +
            " ORDER BY cantidad_usuarios DESC;", nativeQuery = true)
    public List<String[]> frecuencia_habilidad();

    //1. Este query busca todas las habilidades que nadie ha usado.
    //2. Te ayuda a limpiar o depurar tu base de datos (¿para qué guardar habilidades que nadie usa?).
    @Query(value = "SELECT h.id_habilidad, h.nombre\n" +
            "FROM habilidad h\n" +
            "LEFT JOIN detalle d ON h.id_habilidad = d.id_habilidad\n" +
            "WHERE d.id_habilidad IS NULL;", nativeQuery = true)
    public List<String[]> habilidad_sin_usuarios();
}
