package pe.edu.upc.jobfinder.dtos;

import pe.edu.upc.jobfinder.entities.Postulacion;
import pe.edu.upc.jobfinder.entities.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;

public class EntrevistaDTO {
    private int id;
    private LocalDate date;
    private LocalTime hour;
    private String modality;
    private String result;

    private Usuario usuario;
    private Postulacion postulacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Postulacion getPostulacion() {
        return postulacion;
    }

    public void setPostulacion(Postulacion postulacion) {
        this.postulacion = postulacion;
    }
}
