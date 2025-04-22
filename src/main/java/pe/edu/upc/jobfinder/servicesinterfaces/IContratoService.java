package pe.edu.upc.jobfinder.servicesinterfaces;

import pe.edu.upc.jobfinder.entities.Contrato;

import java.util.List;

public interface IContratoService {
    public List<Contrato> list();
    public void insert(Contrato contrato);
    public Contrato searchId(int id);
    public void update(Contrato contrato);
    public void delete(int id);
}
