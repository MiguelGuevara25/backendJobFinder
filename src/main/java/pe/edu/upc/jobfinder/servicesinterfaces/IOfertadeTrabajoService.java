package pe.edu.upc.jobfinder.servicesinterfaces;


import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;

import java.util.List;

public interface IOfertadeTrabajoService {
    public List<OfertadeTrabajo> list();
    public void insert(OfertadeTrabajo ofertadeTrabajo);
    public OfertadeTrabajo searchId(int id);
    public void update(OfertadeTrabajo  OfertadeTrabajo );
    public void delete(int id);
}
