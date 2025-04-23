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
}
