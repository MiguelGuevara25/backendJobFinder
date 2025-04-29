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
    @Column(name = "progresoInscripcionCurso", nullable = false)
    private String progresoInscripcionCurso;

    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;



    public InscripcionCurso() {
    }

    public InscripcionCurso(int idInscripcion, LocalDate fechaInscripcionCurso, String progresoInscripcionCurso, Curso curso, Usuario usuario) {
        this.idInscripcion = idInscripcion;
        this.fechaInscripcionCurso = fechaInscripcionCurso;
        this.progresoInscripcionCurso = progresoInscripcionCurso;
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

    public String getProgresoInscripcionCurso() {
        return progresoInscripcionCurso;
    }

    public void setProgresoInscripcionCurso(String progresoInscripcionCurso) {
        this.progresoInscripcionCurso = progresoInscripcionCurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
