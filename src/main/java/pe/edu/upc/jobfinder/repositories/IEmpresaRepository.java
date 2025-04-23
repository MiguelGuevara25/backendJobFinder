package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.jobfinder.entities.Empresa;

public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {
}
