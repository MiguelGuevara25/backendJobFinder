package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Estudio;
import pe.edu.upc.jobfinder.repositories.IEstudioRepository;
import pe.edu.upc.jobfinder.servicesinterfaces.IEstudioService;

import java.util.List;

@Service
public class EstudioServiceImplement implements IEstudioService {
    @Autowired
    private IEstudioRepository eR;

    @Override
    public List<Estudio> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Estudio e) {
        eR.save(e);
    }

    @Override
    public Estudio searchId(int id) {
        return eR.findById(id).orElse(new Estudio());
    }

    @Override
    public void update(Estudio e) {
        eR.save(e);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }

    @Override
    public List<String[]> buscarCentro(String nombre) {
        return eR.buscarCentro(nombre);
    }

    @Override
    public List<String[]> institucionesMasFrecuentes() {
        return eR.institucionesMasFrecuentes();
    }
}
