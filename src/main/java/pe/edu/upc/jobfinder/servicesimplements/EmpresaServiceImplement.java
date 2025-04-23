package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Empresa;
import pe.edu.upc.jobfinder.repositories.IEmpresaRepository;
import pe.edu.upc.jobfinder.servicesinterfaces.IEmpresaService;

import java.util.List;

@Service
public class EmpresaServiceImplement implements IEmpresaService {
    @Autowired
    private IEmpresaRepository eR;

    @Override
    public List<Empresa> list() {return eR.findAll();}

    @Override
    public void insert(Empresa empresa) {
        eR.save(empresa);
    }

    @Override
    public Empresa searchId(int id) {
        return eR.findById(id).orElse(new Empresa());}

    @Override
    public void update(Empresa empresa) {
        eR.save(empresa);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }
}
