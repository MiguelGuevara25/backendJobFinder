package pe.edu.upc.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.jobfinder.entities.Certificado;

import java.util.List;

public interface ICertificadoRepository extends JpaRepository<Certificado, Integer> {
    @Query(value = "SELECT * \n" +
            "FROM certificado \n" +
            "WHERE fecha_vencimiento_certificado > CURRENT_DATE\n" +
            "ORDER BY fecha_vencimiento_certificado ASC;",nativeQuery = true)
    public List<Certificado> searchActiveCertificaates();
}
