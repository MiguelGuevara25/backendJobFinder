package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;
import pe.edu.upc.jobfinder.entities.Postulacion;
import pe.edu.upc.jobfinder.repositories.IPostulacionRepository;
import pe.edu.upc.jobfinder.servicesinterfaces.IPostulacionService;

import java.util.List;

@Service
public class PostulacionServiceImplement implements IPostulacionService {
    @Autowired
    private IPostulacionRepository pR;

    @Override
    public List<Postulacion> list() {return pR.findAll();}

    @Override
    public void insert(Postulacion postulacion) {pR.save(postulacion);}

    @Override
    public Postulacion searchId(int id) {return pR.findById(id).orElse(new Postulacion());}

    @Override
    public void update(Postulacion postulacion) {pR.save(postulacion);}

    @Override
    public void delete(int id) {pR.deleteById(id);}

    @Override
    public List<String[]> contarPostulacionesPorEstado(Boolean aceptado, Boolean rechazado) {
        return pR.contarPostulacionesPorEstado(aceptado, rechazado);
    }

    @Override
    public List<Postulacion> buscarPostulacionesPorintervalodedias() {
        return pR.buscarPostulacionesporintervalo();
    }



}