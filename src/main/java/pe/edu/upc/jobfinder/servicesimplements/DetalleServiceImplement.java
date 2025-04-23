package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Detalle;
import pe.edu.upc.jobfinder.repositories.IDetalleRepository;
import pe.edu.upc.jobfinder.servicesinterfaces.IDetalleService;

import java.util.List;

@Service
public class DetalleServiceImplement implements IDetalleService {
    @Autowired
    private IDetalleRepository dR;

    @Override
    public List<Detalle> list() {
        return dR.findAll();
    }

    @Override
    public void insert(Detalle detalle) {
        dR.save(detalle);
    }

    @Override
    public Detalle searchId(int id) {
        return dR.findById(id).orElse(new Detalle());
    }

    @Override
    public void update(Detalle detalle) {
        dR.save(detalle);
    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);
    }
}
