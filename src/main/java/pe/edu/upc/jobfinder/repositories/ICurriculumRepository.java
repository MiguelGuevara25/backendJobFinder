package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.jobfinder.entities.Curriculum;

@Repository
public interface ICurriculumRepository extends JpaRepository<Curriculum, Integer> {
}
