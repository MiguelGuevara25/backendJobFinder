package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;
import pe.edu.upc.jobfinder.entities.Usuario;
import pe.edu.upc.jobfinder.entities.Postulacion;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Entrevista")
public class Entrevista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "hour", nullable = false)
    private LocalTime hour;
    @Column(name = "modality", nullable = false, length = 100)
    private String modality;
    @Column(name = "result", nullable = false, length = 100)
    private String result;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "idPostulacion", nullable = false)
    private Postulacion postulacion;

    public Entrevista() {
    }

    public Entrevista(int id, LocalDate date, LocalTime hour, String modality, String result, Usuario usuario, Postulacion postulacion) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.modality = modality;
        this.result = result;
        this.usuario = usuario;
        this.postulacion = postulacion;
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
