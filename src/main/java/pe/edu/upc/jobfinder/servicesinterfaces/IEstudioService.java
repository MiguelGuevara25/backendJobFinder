package pe.edu.upc.jobfinder.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Estudio;

import java.util.List;

public interface IEstudioService {
    public List<Estudio> list();
    public void insert(Estudio e);
    public Estudio searchId(int id);
    public void update(Estudio e);
    public void delete(int id);
    public List<String[]>buscarCentro(@Param("nombre") String nombre);
    public List<String[]> institucionesMasFrecuentes();
}
