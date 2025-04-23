package pe.edu.upc.jobfinder.serviceinterfaces;

import pe.edu.upc.jobfinder.entities.Curriculum;
import pe.edu.upc.jobfinder.entities.Usuario;

import java.util.List;

public interface ICurriculumService {
    public List<Curriculum> listar();
    public void insert(Curriculum curriculum);
    public Curriculum buscarID(int idCurriculum);
    public void update(Curriculum curriculum);
    public void delete(int id);
}
