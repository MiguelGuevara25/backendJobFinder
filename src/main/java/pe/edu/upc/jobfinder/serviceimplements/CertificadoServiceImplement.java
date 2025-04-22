package pe.edu.upc.jobfinder.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Certificado;
import pe.edu.upc.jobfinder.repositories.ICertificadoRepository;
import pe.edu.upc.jobfinder.serviceinterfaces.ICertificadoService;

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
    public void modificar(Certificado certificado) {
        cR.save(certificado);
    }

    @Override
    public void eliminar(int idCertificado) {
        cR.deleteById(idCertificado);
    }
}
