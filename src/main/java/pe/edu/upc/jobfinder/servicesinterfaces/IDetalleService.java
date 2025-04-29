package pe.edu.upc.jobfinder.servicesinterfaces;

import pe.edu.upc.jobfinder.entities.Detalle;

import java.util.List;

public interface IDetalleService {
    public List<Detalle> list();
    public void insert(Detalle detalle);
    public Detalle searchId(int id);
    public void update(Detalle detalle);
    public void delete(int id);
}
