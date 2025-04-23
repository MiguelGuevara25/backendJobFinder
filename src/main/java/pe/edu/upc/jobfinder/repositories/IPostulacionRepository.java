package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;
import pe.edu.upc.jobfinder.entities.Postulacion;

public interface IPostulacionRepository extends JpaRepository<Postulacion, Integer> {

}
