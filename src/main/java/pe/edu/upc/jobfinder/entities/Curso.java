package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    @Column(name = "tituloCurso", nullable = false, length = 50)
    private String tituloCurso;
    @Column(name = "descripcionCurso", nullable = false, length = 50)
    private String descripcionCurso;
    @Column(name = "plataformaCurso", nullable = false, length = 50)
    private String plataformaCurso;
    @Column(name = "linkCurso", nullable = false, length = 50)
    private String linkCurso;

    @ManyToOne
    @JoinColumn(name = "idEmpresa", nullable = false)
    private Empresa empresa;


    public Curso() {
    }

    public Curso(int idCurso, String tituloCurso, String descripcionCurso, String plataformaCurso, String linkCurso, Empresa empresa) {
        this.idCurso = idCurso;
        this.tituloCurso = tituloCurso;
        this.descripcionCurso = descripcionCurso;
        this.plataformaCurso = plataformaCurso;
        this.linkCurso = linkCurso;
        this.empresa = empresa;
    }

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
