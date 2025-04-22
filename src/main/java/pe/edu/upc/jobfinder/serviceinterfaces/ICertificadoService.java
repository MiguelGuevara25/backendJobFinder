package pe.edu.upc.jobfinder.serviceinterfaces;

import pe.edu.upc.jobfinder.entities.Certificado;

import java.util.List;

public interface ICertificadoService {
    public List<Certificado> listar();
    public void insertar(Certificado certificado);
    public void modificar(Certificado certificado);
    public void eliminar(int idCertificado);
}
