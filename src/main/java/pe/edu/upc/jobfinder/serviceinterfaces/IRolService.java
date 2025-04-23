package pe.edu.upc.jobfinder.serviceinterfaces;

import pe.edu.upc.jobfinder.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> listar();
    public void insertar(Rol rol);
    public void update(Rol rol);
    public void delete(int id);
}
