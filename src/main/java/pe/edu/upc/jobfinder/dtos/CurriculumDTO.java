package pe.edu.upc.jobfinder.dtos;


import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.jobfinder.entities.Usuario;

import java.time.LocalDate;

public class CurriculumDTO {
    private int idCurriculum;

    private String descripcionCurriculum;

    private LocalDate fechaCurriculum;

    private Usuario usuario;

    public int getIdCurriculum() {
        return idCurriculum;
    }

    public void setIdCurriculum(int idCurriculum) {
        this.idCurriculum = idCurriculum;
    }

    public String getDescripcionCurriculum() {
        return descripcionCurriculum;
    }

    public void setDescripcionCurriculum(String descripcionCurriculum) {
        this.descripcionCurriculum = descripcionCurriculum;
    }

    public LocalDate getFechaCurriculum() {
        return fechaCurriculum;
    }

    public void setFechaCurriculum(LocalDate fechaCurriculum) {
        this.fechaCurriculum = fechaCurriculum;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
