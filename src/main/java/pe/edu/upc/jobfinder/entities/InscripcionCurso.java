package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "InscripcionCurso")
public class InscripcionCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInscripcion;
    @Column(name = "fechaInscripcionCurso", nullable = false)
    private LocalDate fechaInscripcionCurso;
    @Column(name = "progresoInscripcionCursoñ", nullable = false)
    private int progresoInscripcionCursoñ;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private InscripcionCurso curso;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;



    public InscripcionCurso() {
    }

    public InscripcionCurso(int idInscripcion, LocalDate fechaInscripcionCurso, int progresoInscripcionCursoñ, InscripcionCurso curso, Usuario usuario) {
        this.idInscripcion = idInscripcion;
        this.fechaInscripcionCurso = fechaInscripcionCurso;
        this.progresoInscripcionCursoñ = progresoInscripcionCursoñ;
        this.curso = curso;
        this.usuario = usuario;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public LocalDate getFechaInscripcionCurso() {
        return fechaInscripcionCurso;
    }

    public void setFechaInscripcionCurso(LocalDate fechaInscripcionCurso) {
        this.fechaInscripcionCurso = fechaInscripcionCurso;
    }

    public int getProgresoInscripcionCursoñ() {
        return progresoInscripcionCursoñ;
    }

    public void setProgresoInscripcionCursoñ(int progresoInscripcionCursoñ) {
        this.progresoInscripcionCursoñ = progresoInscripcionCursoñ;
    }

    public InscripcionCurso getCurso() {
        return curso;
    }

    public void setCurso(InscripcionCurso curso) {
        this.curso = curso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
