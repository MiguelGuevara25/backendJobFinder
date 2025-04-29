package pe.edu.upc.jobfinder.servicesinterfaces;

import pe.edu.upc.jobfinder.entities.Habilidad;
import pe.edu.upc.jobfinder.entities.InscripcionCurso;

import java.util.List;

public interface IInscripcionCursoService {
    public List<InscripcionCurso> listar();
    public void insertar(InscripcionCurso inscripcion);
    public InscripcionCurso searchId(int idInscripcion);
    public void modificar(InscripcionCurso inscripcion);
    public void eliminar(int idInscripcion);
    public List<String[]> totalRegistrationByCourse();
    public List<String[]> promedioDeCursos();
}
