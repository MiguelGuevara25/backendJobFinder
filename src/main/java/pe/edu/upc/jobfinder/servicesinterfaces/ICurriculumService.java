package pe.edu.upc.jobfinder.servicesinterfaces;

import pe.edu.upc.jobfinder.entities.Curriculum;

import java.util.List;

public interface ICurriculumService {
    public List<Curriculum> listar();
    public void insert(Curriculum curriculum);
    public Curriculum buscarID(int idCurriculum);
    public void update(Curriculum curriculum);
    public void delete(int id);
    public List<String[]> CurriculumByPromedio();
}
