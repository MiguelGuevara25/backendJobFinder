package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.jobfinder.entities.Detalle;

@Repository
public interface IDetalleRepository extends JpaRepository<Detalle, Integer> {
}
