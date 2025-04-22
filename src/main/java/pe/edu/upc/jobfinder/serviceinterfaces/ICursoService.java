package pe.edu.upc.jobfinder.serviceinterfaces;


import pe.edu.upc.jobfinder.entities.Curso;

import java.util.List;

public interface ICursoService {
    public List<Curso> listar();
    public void insertar(Curso curso);
    public void modificar(Curso curso);
    public void eliminar(int idCurso);
}
