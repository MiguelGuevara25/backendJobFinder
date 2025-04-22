package pe.edu.upc.jobfinder.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.jobfinder.entities.Curso;
import pe.edu.upc.jobfinder.repositories.ICursoRepository;
import pe.edu.upc.jobfinder.serviceinterfaces.ICursoService;

import java.util.List;
@Service
public class CursoServiceImplement implements ICursoService {
    @Autowired
    private ICursoRepository ceR;
    @Override
    public List<Curso> listar() {
        return ceR.findAll();
    }

    @Override
    public void insertar(Curso curso) {
        ceR.save(curso);
    }

    @Override
    public void modificar(Curso curso) {
        ceR.save(curso);
    }

    @Override
    public void eliminar(int idCurso) {
        ceR.deleteById(idCurso);
    }
}
