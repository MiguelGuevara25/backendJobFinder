package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;
import pe.edu.upc.jobfinder.repositories.IOfertadeTrabajoRepository;
import pe.edu.upc.jobfinder.servicesinterfaces.IOfertadeTrabajoService;

import java.util.List;

@Service
public class OfertadeTrabajoServiceImplement implements IOfertadeTrabajoService {
    @Autowired
    private IOfertadeTrabajoRepository oR;

    @Override
    public List<OfertadeTrabajo> list() {return oR.findAll();}

    @Override
    public void insert(OfertadeTrabajo ofertadetrabajo) {oR.save(ofertadetrabajo);}

    @Override
    public OfertadeTrabajo searchId(int id) {return oR.findById(id).orElse(new OfertadeTrabajo());}

    @Override
    public void update(OfertadeTrabajo ofertadeTrabajo) {oR.save(ofertadeTrabajo);}

    @Override
    public void delete(int id) {oR.deleteById(id);}


    @Override
    public List<OfertadeTrabajo> buscarOfertasPorSalarioYUbicacion(double salarioMinimo, String ubicacion)
    {return oR.buscarOfertasPorSalarioYUbicacion(salarioMinimo, ubicacion);}

    @Override
    public List<String[]> buscarOfertasPorUbicacionYContratoConEmpresa(String ubicacion, String tipoContrato)
        {return oR.buscarOfertasPorUbicacionYContratoConEmpresa(ubicacion,tipoContrato);}
}

