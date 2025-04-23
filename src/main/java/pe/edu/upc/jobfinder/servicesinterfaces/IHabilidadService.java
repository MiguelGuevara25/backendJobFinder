package pe.edu.upc.jobfinder.servicesinterfaces;

import pe.edu.upc.jobfinder.entities.Habilidad;

import java.util.List;

public interface IHabilidadService {
    public List<Habilidad> list();
    public void insert(Habilidad h);
    public Habilidad searchId(int id);
    public void update(Habilidad h);
}
