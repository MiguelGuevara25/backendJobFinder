package pe.edu.upc.jobfinder.servicesinterfaces;

import pe.edu.upc.jobfinder.entities.Experiencia;

import java.util.List;

public interface IExperienciaService {
    public List<Experiencia> list();
    public void insert(Experiencia e);
    public Experiencia searchId(int id);
    public void update (Experiencia e);
    public void delete (int id);
}
