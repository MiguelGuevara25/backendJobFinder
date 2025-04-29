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
    @Column(name = "progresoInscripcionCursoñ", nullable = false)
    private int progresoInscripcionCursoñ;

    @ManyToOne
    @JoinColumn(name = "curso")
    private InscripcionCurso curso;




    public InscripcionCurso() {
    }


}
