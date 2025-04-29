package pe.edu.upc.jobfinder.servicesinterfaces;

import pe.edu.upc.jobfinder.entities.Habilidad;

import java.util.List;

public interface IHabilidadService {
    public List<Habilidad> list();

    public void insert(Habilidad h);

    public Habilidad searchId(int id);

    public void update(Habilidad h);

    public void delete(int h);

    public List<String[]> frecuencia_habilidad();
    public List<String[]> habilidad_sin_usuarios();
}
