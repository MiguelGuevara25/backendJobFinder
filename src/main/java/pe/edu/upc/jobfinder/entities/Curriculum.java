package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Curriculum")
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurriculum;

    @Column(name = "descripcion",nullable = false,length = 250)
    private String descripcionCurriculum;

    @Column(name = "fecha",nullable = false)
    private LocalDate fechaCurriculum;

    @ManyToOne
    @JoinColumn(name = "id_usuario",nullable = false)
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
