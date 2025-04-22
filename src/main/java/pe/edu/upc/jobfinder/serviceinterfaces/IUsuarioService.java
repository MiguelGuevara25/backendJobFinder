package pe.edu.upc.jobfinder.serviceinterfaces;


import pe.edu.upc.jobfinder.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listar();

    public void insertar(Usuario usuario);

    public Usuario buscarID(int idUsuario);
    public void modificar(Usuario usuario);
    public void eliminar(int idUsuario);
}