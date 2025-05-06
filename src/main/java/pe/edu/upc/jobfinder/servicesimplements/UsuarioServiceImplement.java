package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Usuario;
import pe.edu.upc.jobfinder.repositories.IUsuarioRepository;
import pe.edu.upc.jobfinder.servicesinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService{

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public void insertar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarID(int idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(new Usuario());
    }

    @Override
    public void modificar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(int idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    @Override
    public List<String[]> listaXactivos(boolean estado) {
        return usuarioRepository.listaXactivos(estado);
    }

    @Override
    public List<Usuario> buscar(String nombre) {
        return usuarioRepository.buscar(nombre);
    }

    @Override
    public List<String[]> UsuariosXEntrevistasExitosas(String estado) {
        return usuarioRepository.UsuariosXEntrevistasExitosas(estado);
    }

    @Override
    public List<String[]> UsuariosXDetalles(int id) {
        return usuarioRepository.UsuariosXDetalles(id);
    }

    @Override
    public List<String[]> UsuariosXcontratosActivos() {
        return usuarioRepository.UsuariosXcontratosActivos();
    }
}
