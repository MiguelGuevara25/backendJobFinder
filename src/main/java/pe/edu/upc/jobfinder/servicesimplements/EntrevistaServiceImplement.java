package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Contrato;
import pe.edu.upc.jobfinder.entities.Entrevista;
import pe.edu.upc.jobfinder.repositories.IEntrevistaRepository;
import pe.edu.upc.jobfinder.servicesinterfaces.IEntrevistaService;

import java.util.List;

@Service
public class EntrevistaServiceImplement implements IEntrevistaService {
    @Autowired
    private IEntrevistaRepository eR;

    @Override
    public List<Entrevista> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Entrevista entrevista) {
        eR.save(entrevista);
    }

    @Override
    public Entrevista searchId(int id) {
        return eR.findById(id).orElse(new Entrevista());
    }

    @Override
    public void update(Entrevista entrevista) {
        eR.save(entrevista);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }
}
