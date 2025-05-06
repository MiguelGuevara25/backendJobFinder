package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Postulacion;

import java.util.List;

public interface IPostulacionRepository extends JpaRepository<Postulacion, Integer> {

    @Query(value = "SELECT p.state, COUNT(*) AS cantidad_postulaciones " +
            "FROM Postulacion p " +
            "WHERE p.acceptedcandidate = :aceptado " +
            "GROUP BY p.state", nativeQuery = false)
    public List<String[]> contarPostulacionesPorEstado(@Param("aceptado") Boolean aceptado);

    @Query("SELECT p FROM Postulacion p WHERE p.acceptedcandidate = :aceptado")
    public List<Postulacion> buscarPostulacionesPorAceptacion(@Param("aceptado") Boolean aceptado);
}
