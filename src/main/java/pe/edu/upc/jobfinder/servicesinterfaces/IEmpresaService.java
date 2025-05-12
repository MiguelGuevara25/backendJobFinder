package pe.edu.upc.jobfinder.servicesinterfaces;


import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Empresa;

import java.util.List;

public interface IEmpresaService {
    public List<Empresa> list();
    public void insert(Empresa empresa);
    public Empresa searchId(int id);
    public void update(Empresa Empresa);
    public void delete(int id);
    public List<String[]> buscarPorSector(String nombre);
    public List<String[]> contarEmpresasPorUbicacion(String sector);
}
