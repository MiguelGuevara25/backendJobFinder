package pe.edu.upc.jobfinder.dtos;

import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;

import java.time.LocalDate;

public class PostulacionEstadoDTO {

    private String state;
    private int totalPostulaciones;
    private int aceptadas;
    private int rechazadas;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getTotalPostulaciones() {
        return totalPostulaciones;
    }

    public void setTotalPostulaciones(int totalPostulaciones) {
        this.totalPostulaciones = totalPostulaciones;
    }

    public int getAceptadas() {
        return aceptadas;
    }

    public void setAceptadas(int aceptadas) {
        this.aceptadas = aceptadas;
    }

    public int getRechazadas() {
        return rechazadas;
    }

    public void setRechazadas(int rechazadas) {
        this.rechazadas = rechazadas;
    }
}
