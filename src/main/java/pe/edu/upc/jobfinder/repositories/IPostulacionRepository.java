package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Postulacion;

import java.util.List;

public interface IPostulacionRepository extends JpaRepository<Postulacion, Integer> {

    @Query(value = "SELECT state, \n" +
            "       COUNT(*) AS total_postulaciones,\n" +
            "       SUM(CASE WHEN acceptedcandidate THEN 1 ELSE 0 END) AS aceptadas,\n" +
            "       SUM(CASE WHEN NOT acceptedcandidate THEN 1 ELSE 0 END) AS rechazadas\n" +
            "FROM postulacion\n" +
            "GROUP BY state\n" +
            "ORDER BY total_postulaciones DESC", nativeQuery = true)
    public List<String[]> contarPostulacionesPorEstado(@Param("aceptado") Boolean aceptado,@Param("rechazado") Boolean rechazado) ;

    @Query(value = "SELECT id, date, state, acceptedcandidate\n" +
            "FROM postulacion\n" +
            "WHERE date BETWEEN CURRENT_DATE - INTERVAL '9 days' AND CURRENT_DATE\n" +
            "ORDER BY date DESC", nativeQuery = true)
    public List<Postulacion> buscarPostulacionesporintervalo();
}
