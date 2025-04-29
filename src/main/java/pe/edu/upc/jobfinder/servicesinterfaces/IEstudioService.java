package pe.edu.upc.jobfinder.servicesinterfaces;

import pe.edu.upc.jobfinder.entities.Estudio;

import java.util.List;

public interface IEstudioService {
    public List<Estudio> list();
    public void insert(Estudio e);
    public Estudio searchId(int id);
    public void update(Estudio e);
    public void delete(int id);
}
