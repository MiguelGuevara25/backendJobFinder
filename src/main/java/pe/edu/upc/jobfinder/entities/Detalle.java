package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Detalle")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idExperiencia")
    private Experiencia experiencias;

    @ManyToOne
    @JoinColumn(name = "idEstudio")
    private Estudio estudios;

    @ManyToOne
    @JoinColumn(name = "idHabilidad")
    private Habilidad habilidades;

    @ManyToOne
    @JoinColumn(name = "idCurriculum")
    private Curriculum curriculums;
    //private Certificado certificados;


    public Detalle() {
    }

    public Detalle(int id, Experiencia experiencias, Estudio estudios, Habilidad habilidades, Curriculum curriculums) {
        this.id = id;
        this.experiencias = experiencias;
        this.estudios = estudios;
        this.habilidades = habilidades;
        this.curriculums = curriculums;
    }

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
}
