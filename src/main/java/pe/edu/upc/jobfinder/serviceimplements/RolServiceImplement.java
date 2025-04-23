package pe.edu.upc.jobfinder.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Rol;
import pe.edu.upc.jobfinder.repositories.IRolRepository;
import pe.edu.upc.jobfinder.serviceinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {
    @Autowired
    IRolRepository rolRepository;

    @Override
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    @Override
    public void insertar(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void update(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void delete(int id) {
        rolRepository.deleteById(id);
    }
}
