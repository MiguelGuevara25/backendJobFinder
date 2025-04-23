package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.jobfinder.entities.Rol;

public interface IRolRepository extends JpaRepository<Rol, Integer> {

}
