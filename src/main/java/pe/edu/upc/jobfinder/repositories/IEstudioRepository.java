package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.jobfinder.entities.Estudio;

public interface IEstudioRepository extends JpaRepository<Estudio, Integer> {
}
