package pe.edu.upc.jobfinder.dtos;

import pe.edu.upc.jobfinder.entities.*;

public class DetalleDTO {
    private int id;
    private Experiencia experiencias;
    private Estudio estudios;
    private Habilidad habilidades;
    private Curriculum curriculums;
    private Certificado certificados;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Experiencia getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(Experiencia experiencias) {
        this.experiencias = experiencias;
    }

    public Estudio getEstudios() {
        return estudios;
    }

    public void setEstudios(Estudio estudios) {
        this.estudios = estudios;
    }

    public Habilidad getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Habilidad habilidades) {
        this.habilidades = habilidades;
    }

    public Curriculum getCurriculums() {
        return curriculums;
    }

    public void setCurriculums(Curriculum curriculums) {
        this.curriculums = curriculums;
    }

    public Certificado getCertificados() {
        return certificados;
    }

    public void setCertificados(Certificado certificados) {
        this.certificados = certificados;
    }
}
