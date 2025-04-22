package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Entrevista")
public class Entrevista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "hour", nullable = false)
    private LocalTime hour;
    @Column(name = "modality", nullable = false, length = 100)
    private String modality;
    @Column(name = "result", nullable = false, length = 100)
    private String result;

    //private Usuario usuario;
    //private Postulacion postulacion;
}
