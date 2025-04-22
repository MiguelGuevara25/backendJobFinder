package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Contrato;
import pe.edu.upc.jobfinder.servicesinterfaces.IContratoService;

import java.util.List;

@Service
public class ContratoServiceImplement implements IContratoService {
    @Override
    public List<Contrato> list() {
        return List.of();
    }

    @Override
    public void insert(Contrato contrato) {

    }

    @Override
    public Contrato searchId(int id) {
        return null;
    }

    @Override
    public void update(Contrato contrato) {

    }

    @Override
    public void delete(int id) {

    }
}
