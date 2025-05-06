package pe.edu.upc.jobfinder.servicesinterfaces;

import pe.edu.upc.jobfinder.entities.Entrevista;

import java.util.List;

public interface IEntrevistaService {
    public List<Entrevista> list();
    public void insert(Entrevista entrevista);
    public Entrevista searchId(int id);
    public void update(Entrevista entrevista);
    public void delete(int id);
    public List<String[]> quantityInterview();
    public List<String[]> interviewsLast30Days();
}
