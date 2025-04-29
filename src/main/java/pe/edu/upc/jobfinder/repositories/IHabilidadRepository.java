package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.jobfinder.entities.Habilidad;

import java.util.List;

@Repository
public interface IHabilidadRepository extends JpaRepository<Habilidad, Integer> {
    @Query(value = "SELECT h.nombre, COUNT(*) AS cantidad_usuarios\n" +
            " FROM habilidad h\n" +
            " INNER JOIN detalle d ON h.id_habilidad = d.id_habilidad\n" +
            " GROUP BY h.nombre\n" +
            " ORDER BY cantidad_usuarios DESC;", nativeQuery = true)
    public List<String[]> frecuencia_habilidad();
}
