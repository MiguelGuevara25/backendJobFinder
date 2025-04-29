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

    @ManyToOne
    @JoinColumn(name = "joboffer_id_oferta", nullable = false)
    private OfertadeTrabajo ofertaTrabajo;

    public Postulacion() {
    }

    public Postulacion(int id, LocalDate date, String state, Boolean acceptedcandidate, OfertadeTrabajo ofertaTrabajo) {
        this.id = id;
        this.date = date;
        this.state = state;
        this.acceptedcandidate = acceptedcandidate;
        this.ofertaTrabajo = ofertaTrabajo;
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

    public OfertadeTrabajo getOfertaTrabajo() {
        return ofertaTrabajo;
    }

    public void setOfertaTrabajo(OfertadeTrabajo ofertaTrabajo) {
        this.ofertaTrabajo = ofertaTrabajo;
    }
}
