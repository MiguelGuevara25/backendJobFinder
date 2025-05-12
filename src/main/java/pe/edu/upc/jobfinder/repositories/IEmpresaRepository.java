package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Empresa;

import java.util.List;

public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {

    @Query(value = "SELECT \n" +
            "    c.sector,\n" +
            "    c.namecompany\n" +
            "FROM \n" +
            "    empresa c\n" +
            "WHERE \n" +
            "    c.sector LIKE %:sector%;", nativeQuery = true)
    public List<String[]> buscarPorSector(@Param("nombre") String nombre);

    @Query(value = "SELECT \n" +
            "    c.location,\n" +
            "    c.sector,\n" +
            "    COUNT(*) AS cantidad_empresas\n" +
            "FROM \n" +
            "    empresa c\n" +
            "WHERE \n" +
            "    c.location = %:ubicacion%\n" +
            "GROUP BY \n" +
            "    c.location,\n" +
            "    c.sector\n" +
            "ORDER BY \n" +
            "    cantidad_empresas DESC;", nativeQuery = true)
    public List<String[]> contarEmpresasPorUbicacion(@Param("sector") String sector);
}
