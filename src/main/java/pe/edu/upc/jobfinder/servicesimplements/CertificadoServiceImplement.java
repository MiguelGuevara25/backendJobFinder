package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Certificado;
import pe.edu.upc.jobfinder.entities.Contrato;
import pe.edu.upc.jobfinder.repositories.ICertificadoRepository;
import pe.edu.upc.jobfinder.servicesinterfaces.ICertificadoService;

import java.util.List;

@Service
public class CertificadoServiceImplement implements ICertificadoService {
    @Autowired
    private ICertificadoRepository cR;
    @Override
    public List<Certificado> listar() {
        return cR.findAll();
    }

    @Override
    public void insertar(Certificado certificado) {
        cR.save(certificado);
    }

    @Override
    public Certificado searchId(int idCertificado) {
        return cR.findById(idCertificado).orElse(new Certificado());
    }

    @Override
    public void modificar(Certificado certificado) {
        cR.save(certificado);
    }

    @Override
    public void eliminar(int idCertificado) {
        cR.deleteById(idCertificado);
    }

    @Override
    public List<Certificado> searchActiveCertificaates() {
        return cR.searchActiveCertificaates();
    }

    @Override
    public List<String[]> quantyCertificateByYear() {
        return cR.quantityCertificateByYear();
    }
}
