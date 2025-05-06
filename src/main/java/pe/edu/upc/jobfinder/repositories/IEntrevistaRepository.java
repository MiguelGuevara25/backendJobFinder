package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.jobfinder.entities.Entrevista;

import java.util.List;

@Repository
public interface IEntrevistaRepository extends JpaRepository<Entrevista, Integer> {
    @Query(value = "SELECT COUNT(*) FROM entrevista", nativeQuery = true)
    public List<String[]> quantityInterview();

    @Query(value = "SELECT e.date, e.hour, u.nombre, u.apellido, u.telefono, u.correo\n" +
            " FROM entrevista e\n" +
            " JOIN users u ON e.id_usuario = u.id_usuario\n" +
            " WHERE \"date\" >= CURRENT_DATE - 30", nativeQuery = true)
    public List<String[]> interviewsLast30Days();
}
