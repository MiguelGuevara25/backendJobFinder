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
    @Query(value = "SELECT * FROM contrato c WHERE c.contract_type ILIKE '%:contractType%';",nativeQuery = true)
    public List<Contrato> searchByContractType(@Param("contractType") String contractType);
}
