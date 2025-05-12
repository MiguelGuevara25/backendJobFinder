package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;
import java.util.List;
public interface IOfertadeTrabajoRepository extends JpaRepository<OfertadeTrabajo, Integer> {

    @Query(value = "SELECT o.name,o.salary, o.location AS empresa_name\n" +
            "FROM ofertade_trabajo o\n" +
            "JOIN empresa e ON o.id_empresa = e.id\n" +
            "WHERE o.salary = '3000' AND o.location = 'Lima';", nativeQuery =true)
    public List<OfertadeTrabajo> buscarOfertasPorSalarioYUbicacion(@Param("salarioMinimo") double salarioMinimo, @Param("ubicacion") String ubicacion);
    @Query(value = "SELECT o.name, o.location, o.typeofcontract AS empresa_name\n" +
            "FROM ofertade_trabajo o\n" +
            "JOIN empresa e ON o.id_empresa = e.id\n" +
            "WHERE o.location = %:ubicacion% AND o.typeofcontract = %:tipocontrato%;",nativeQuery = true)
    public List<String[]> buscarOfertasPorUbicacionYContratoConEmpresa(@Param("ubicacion") String ubicacion, @Param("tipoContrato") String tipoContrato);
}
