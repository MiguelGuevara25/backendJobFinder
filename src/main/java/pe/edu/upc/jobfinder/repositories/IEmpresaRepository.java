package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.jobfinder.entities.Empresa;

import java.util.List;

public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {

}
