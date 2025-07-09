package pe.edu.upc.jobfinder.servicesinterfaces;


import org.springframework.data.repository.query.Param;
import pe.edu.upc.jobfinder.entities.Postulacion;

import java.util.List;

public interface IPostulacionService {
        public List<Postulacion> list();
        public void insert (Postulacion postulacion);
        public Postulacion searchId(int id);
        public void update(Postulacion Postulacion);
        public void delete(int id);
        public List<String[]> contarPostulacionesPorEstado(Boolean aceptado, Boolean rechazado);
        public List<String[]> buscarPostulacionesPorintervalodedias();
}
