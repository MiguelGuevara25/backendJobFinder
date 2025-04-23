package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Empresa;

import java.util.List;

public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {
    @Query("Select a from App a where a.nameApp like %:nombre%")
    public List<App> buscar(@Param("nombre") String nombre);
}
