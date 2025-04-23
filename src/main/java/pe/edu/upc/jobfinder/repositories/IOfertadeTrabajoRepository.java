package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;

public interface IOfertadeTrabajoRepository extends JpaRepository<OfertadeTrabajo, Integer> {

}
