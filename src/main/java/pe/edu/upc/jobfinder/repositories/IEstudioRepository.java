package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Estudio;

import java.util.List;

public interface IEstudioRepository extends JpaRepository<Estudio, Integer> {
    @Query(value = "SELECT e.study_center, COUNT (*) AS cantidad_registros\n" +
            " FROM Estudio e\n" +
            " WHERE e.study_center like %:nombre%\n" +
            " GROUP BY e.study_center", nativeQuery = true)
    public List<String[]>buscarCentro(@Param("nombre") String nombre);

    @Query(value  = "SELECT e.study_center, COUNT(*) AS veces_registrada\n" +
            " FROM estudio e\n" +
            " GROUP BY e.study_center\n" +
            " ORDER BY veces_registrada DESC;" ,nativeQuery = true)
    public List<String[]> institucionesMasFrecuentes();

}
