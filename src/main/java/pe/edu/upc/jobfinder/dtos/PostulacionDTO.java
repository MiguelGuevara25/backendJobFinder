package pe.edu.upc.jobfinder.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class PostulacionDTO {

    private int id;
    private LocalDate date;
    private String state;
    private Boolean acceptedcandidate;
    private String joboffer_id_oferta;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getAcceptedcandidate() {
        return acceptedcandidate;
    }

    public void setAcceptedcandidate(Boolean acceptedcandidate) {
        this.acceptedcandidate = acceptedcandidate;
    }

    public String getJoboffer_id_oferta() {
        return joboffer_id_oferta;
    }

    public void setJoboffer_id_oferta(String joboffer_id_oferta) {
        this.joboffer_id_oferta = joboffer_id_oferta;
    }
}
