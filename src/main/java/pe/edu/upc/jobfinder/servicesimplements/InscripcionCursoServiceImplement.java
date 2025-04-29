package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.jobfinder.entities.InscripcionCurso;
import pe.edu.upc.jobfinder.repositories.IInscripcionCursoRepository;
import pe.edu.upc.jobfinder.servicesinterfaces.IInscripcionCursoService;

import java.util.List;

@Service
public class InscripcionCursoServiceImplement implements IInscripcionCursoService {
    @Autowired
    private IInscripcionCursoRepository iR;
    @Override
    public List<InscripcionCurso> listar() {
        return iR.findAll();
    }

    @Override
    public void insertar(InscripcionCurso inscripcion) {
        iR.save(inscripcion);
    }

    @Override
    public void modificar(InscripcionCurso inscripcion) {
        iR.save(inscripcion);
    }

    @Override
    public void eliminar(int idInscripcion) {
        iR.deleteById(idInscripcion);
    }
}
