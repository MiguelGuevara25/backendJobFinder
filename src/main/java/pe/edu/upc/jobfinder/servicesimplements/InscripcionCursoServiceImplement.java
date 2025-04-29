package pe.edu.upc.jobfinder.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.jobfinder.entities.Habilidad;
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
    public InscripcionCurso searchId(int idInscripcion) {
        return iR.findById(idInscripcion).orElse(new InscripcionCurso());
    }

    @Override
    public void modificar(InscripcionCurso inscripcion) {
        iR.save(inscripcion);
    }

    @Override
    public void eliminar(int idInscripcion) {
        iR.deleteById(idInscripcion);
    }

    @Override
    public List<String[]> totalRegistrationByCourse() {
        return iR.totalRegistrationByCourse();
    }

    @Override
    public List<String[]> promedioDeCursos() {
        return iR.promedioDeCursos();
    }
}
