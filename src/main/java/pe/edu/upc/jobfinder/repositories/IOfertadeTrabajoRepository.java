package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;
import java.util.List;
public interface IOfertadeTrabajoRepository extends JpaRepository<OfertadeTrabajo, Integer> {

    @Query("SELECT o FROM OfertadeTrabajo o WHERE o.salary >= :salarioMinimo AND o.location = :ubicacion")
    public List<OfertadeTrabajo> buscarOfertasPorSalarioYUbicacion(@Param("salarioMinimo") double salarioMinimo, @Param("ubicacion") String ubicacion);
    @Query("SELECT o.name, o.salary, o.typeofcontract, e.name " +
            "FROM OfertadeTrabajo o JOIN o.empresa e " +
            "WHERE o.location = :ubicacion AND o.typeofcontract = :tipoContrato")
    public List<String[]> buscarOfertasPorUbicacionYContratoConEmpresa(@Param("ubicacion") String ubicacion, @Param("tipoContrato") String tipoContrato);

}
