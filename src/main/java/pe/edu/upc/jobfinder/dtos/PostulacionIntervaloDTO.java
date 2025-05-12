package pe.edu.upc.jobfinder.dtos;

import pe.edu.upc.jobfinder.entities.OfertadeTrabajo;

import java.time.LocalDate;

public class PostulacionIntervaloDTO {
    private int id;
    private LocalDate date;

    private String state;

    private Boolean acceptedcandidate;


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

}
