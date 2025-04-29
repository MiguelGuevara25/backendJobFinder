package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Contrato;
import pe.edu.upc.jobfinder.repositories.IContratoRepository;
import pe.edu.upc.jobfinder.servicesinterfaces.IContratoService;

import java.util.List;

@Service
public class ContratoServiceImplement implements IContratoService {
    @Autowired
    private IContratoRepository cR;

    @Override
    public List<Contrato> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Contrato contrato) {
        cR.save(contrato);
    }

    @Override
    public Contrato searchId(int id) {
        return cR.findById(id).orElse(new Contrato());
    }

    @Override
    public void update(Contrato contrato) {
        cR.save(contrato);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public List<Contrato> searchByContractType(String contractType) {
        return cR.searchByContractType(contractType);
    }
}
