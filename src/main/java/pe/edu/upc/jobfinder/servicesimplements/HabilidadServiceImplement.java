package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Habilidad;
import pe.edu.upc.jobfinder.repositories.IHabilidadRepository;
import pe.edu.upc.jobfinder.servicesinterfaces.IHabilidadService;

import java.util.List;

@Service
public class HabilidadServiceImplement implements IHabilidadService {
    @Autowired
    private IHabilidadRepository hR;

    @Override
    public List<Habilidad> list() {
        return hR.findAll();
    }

    @Override
    public void insert(Habilidad h) {
        hR.save(h);
    }

    @Override
    public Habilidad searchId(int id) {
        return hR.findById(id).orElse(new Habilidad());
    }

    @Override
    public void update(Habilidad h) {
        hR.save(h);
    }

    @Override
    public void delete(int h) {
        hR.deleteById(h);
    }
}
