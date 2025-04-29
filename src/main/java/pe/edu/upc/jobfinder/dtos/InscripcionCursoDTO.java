package pe.edu.upc.jobfinder.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.jobfinder.entities.Curso;
import pe.edu.upc.jobfinder.entities.InscripcionCurso;
import pe.edu.upc.jobfinder.entities.Usuario;

import java.time.LocalDate;

public class InscripcionCursoDTO {
    private int idInscripcion;
    private LocalDate fechaInscripcionCurso;
    private String progresoInscripcionCurso;
    private Curso curso;
    private Usuario usuario;

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
