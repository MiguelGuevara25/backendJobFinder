package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name= "Postulacion")
public class Postulacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "state", nullable = false, length = 100)
    private String state;
    @Column(name = "acceptedcandidate", nullable = false)
    private Boolean acceptedcandidate;
    @Column(name = "joboffer_id_oferta", nullable = false, length = 100)
    private String joboffer_id_oferta;

    public Postulacion() {
    }

    public Postulacion(int id, LocalDate date, String state, Boolean acceptedcandidate, String joboffer_id_oferta) {
        this.id = id;
        this.date = date;
        this.state = state;
        this.acceptedcandidate = acceptedcandidate;
        this.joboffer_id_oferta = joboffer_id_oferta;
    }

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
