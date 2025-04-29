package pe.edu.upc.jobfinder.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> listar();
    public void insertar(Rol rol);
    public Rol listarid(int id);
    public void update(Rol rol);
    public void delete(int id);
    public List<String[]> rolesXusuario();
    public List<String[]> promedioYcantidadXrol(String nombre);

}
