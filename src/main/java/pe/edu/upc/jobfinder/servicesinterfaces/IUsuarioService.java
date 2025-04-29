package pe.edu.upc.jobfinder.servicesinterfaces;


import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listar();

    public void insertar(Usuario usuario);

    public Usuario buscarID(int idUsuario);
    public void modificar(Usuario usuario);
    public void eliminar(int idUsuario);
    public List<String[]> listaXactivos(boolean estado);
    public List<Usuario> buscar(String nombre);
}