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
}
