package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Empresa;

import java.util.List;

public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {
    @Query(value = "SELECT c.namecompany, c.sector, c.mail " +
            "FROM company c " +
            "WHERE c.sector = :sector " +
            "ORDER BY c.namecompany ASC " +
            "LIMIT :limite", nativeQuery = true)
    public List<String[]> listarEmpresasPorSectorOrdenadas(@Param("sector") String sector, @Param("limite") int limite);
    @Query("SELECT e.name, e.sector, COUNT(DISTINCT o.id), COUNT(p.id) " +
            "FROM Empresa e " +
            "LEFT JOIN e.ofertaTrabajo o " +
            "LEFT JOIN Postulacion p ON p.ofertaTrabajo = o " +
            "WHERE e.location = :ubicacion " +
            "GROUP BY e.name, e.sector")
    public List<String[]> contarOfertasYPostulacionesPorEmpresa(@Param("ubicacion") String ubicacion);
}
