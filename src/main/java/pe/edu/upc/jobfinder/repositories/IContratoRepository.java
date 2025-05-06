package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.jobfinder.entities.Contrato;
import pe.edu.upc.jobfinder.entities.Curso;

import java.util.List;

@Repository
public interface IContratoRepository extends JpaRepository<Contrato, Integer> {
    @Query(value = "SELECT c.end_date, c.start_date, c.contract_type FROM contrato c WHERE c.contract_type ILIKE '%' || :contractType || '%'", nativeQuery = true)
    public List<String[]> searchByContractType(@Param("contractType") String contractType);

    @Query(value = "SELECT c.salary, u.nombre, u.apellido, u.correo, ot.name\n" +
            " FROM contrato c\n" +
            " JOIN users u ON c.id_usuario = u.id_usuario\n" +
            " JOIN postulacion p ON c.id_postulacion = p.id\n" +
            " JOIN ofertade_trabajo ot ON p.id = ot.id\n" +
            " WHERE c.salary < :salary", nativeQuery = true)
    public List<String[]> searchSalary(@Param("salary") Double salary);
}
