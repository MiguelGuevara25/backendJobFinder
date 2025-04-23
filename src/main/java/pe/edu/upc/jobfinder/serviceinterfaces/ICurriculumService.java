package pe.edu.upc.jobfinder.serviceinterfaces;

import pe.edu.upc.jobfinder.entities.Curriculum;

import java.util.List;

public interface ICurriculumService {
    public List<Curriculum> listar();
    public void insert(Curriculum curriculum);
    public void update(Curriculum curriculum);
    public void delete(int id);
}
