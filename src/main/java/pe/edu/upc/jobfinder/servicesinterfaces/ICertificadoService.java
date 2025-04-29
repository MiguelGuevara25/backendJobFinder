package pe.edu.upc.jobfinder.servicesinterfaces;

import pe.edu.upc.jobfinder.entities.Certificado;
import pe.edu.upc.jobfinder.entities.Contrato;

import java.util.List;

public interface ICertificadoService {
    public List<Certificado> listar();
    public void insertar(Certificado certificado);
    public Certificado searchId(int idCertificado);
    public void modificar(Certificado certificado);
    public void eliminar(int idCertificado);
    public List<Certificado> searchActiveCertificaates();
    public List<String[]> quantyCertificateByYear();
}
