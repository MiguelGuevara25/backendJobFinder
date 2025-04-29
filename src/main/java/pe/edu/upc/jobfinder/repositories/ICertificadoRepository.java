package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.jobfinder.entities.Certificado;

public interface ICertificadoRepository extends JpaRepository<Certificado, Integer> {
}
