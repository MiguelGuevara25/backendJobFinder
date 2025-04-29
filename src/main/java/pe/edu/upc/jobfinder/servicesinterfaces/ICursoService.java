package pe.edu.upc.jobfinder.servicesinterfaces;


import pe.edu.upc.jobfinder.entities.Curso;
import pe.edu.upc.jobfinder.entities.Detalle;

import java.util.List;

public interface ICursoService {
    public List<Curso> listar();
    public void insertar(Curso curso);
    public void modificar(Curso curso);
    public Curso searchId(int idCurso);
    public void eliminar(int idCurso);
}
