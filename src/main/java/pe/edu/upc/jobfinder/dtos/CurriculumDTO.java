package pe.edu.upc.jobfinder.dtos;


import java.time.LocalDate;

public class CurriculumDTO {
    private int idCurriculum;
    private String descripcionCurriculum;
    private LocalDate fechaCurriculum;

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
}
