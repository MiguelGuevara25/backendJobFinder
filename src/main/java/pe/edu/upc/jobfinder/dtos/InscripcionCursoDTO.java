package pe.edu.upc.jobfinder.dtos;

import pe.edu.upc.jobfinder.entities.InscripcionCurso;

import java.time.LocalDate;

public class InscripcionCursoDTO {
    private int idInscripcion;
    private LocalDate fechaInscripcionCurso;
    private int progresoInscripcionCursoñ;
    private InscripcionCurso curso;

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
}
