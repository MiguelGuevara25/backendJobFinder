package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.dtos.ExperienciaDTO;
import pe.edu.upc.jobfinder.entities.Experiencia;
import pe.edu.upc.jobfinder.repositories.IExperienciaRepository;
import pe.edu.upc.jobfinder.servicesinterfaces.IExperienciaService;

import java.util.List;

@Service
public class ExperienciaServiceImplement implements IExperienciaService {
    @Autowired
    private IExperienciaRepository eR;

    @Override
    public List<Experiencia> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Experiencia e) {
        eR.save(e);
    }

    @Override
    public Experiencia searchId(int id) {
        return eR.findById(id).orElse(new Experiencia());
    }

    @Override
    public void update(Experiencia e) {
        eR.save(e);
    }
}
