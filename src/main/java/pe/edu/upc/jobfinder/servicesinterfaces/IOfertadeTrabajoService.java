package pe.edu.upc.jobfinder.servicesinterfaces;



import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;

import java.util.List;

public interface IOfertadeTrabajoService {
    public List<OfertadeTrabajo> list();
    public void insert(OfertadeTrabajo ofertadetrabajo);
    public OfertadeTrabajo searchId(int id);
    public void update(OfertadeTrabajo OfertadeTrabajo);
    public void delete(int id);
    public List<String[]> buscarOfertasPorSalarioYUbicacion(double salarioMinimo, String ubicacion);
    public List<String[]> buscarOfertasPorUbicacionYContratoConEmpresa( String ubicacion, String tipoContrato);
}
