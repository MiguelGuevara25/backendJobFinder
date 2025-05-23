package pe.edu.upc.jobfinder.dtos;

import jakarta.persistence.Column;
import pe.edu.upc.jobfinder.entities.Empresa;

public class CursoDTO {
    private int idCurso;
    private String tituloCurso;
    private String descripcionCurso;
    private String plataformaCurso;
    private String linkCurso;

    private Empresa empresa;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    public String getPlataformaCurso() {
        return plataformaCurso;
    }

    public void setPlataformaCurso(String plataformaCurso) {
        this.plataformaCurso = plataformaCurso;
    }

    public String getLinkCurso() {
        return linkCurso;
    }

    public void setLinkCurso(String linkCurso) {
        this.linkCurso = linkCurso;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
