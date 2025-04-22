package pe.edu.upc.jobfinder.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Usuario;
import pe.edu.upc.jobfinder.repositories.IUsuarioRepository;
import pe.edu.upc.jobfinder.serviceinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService{

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
}
