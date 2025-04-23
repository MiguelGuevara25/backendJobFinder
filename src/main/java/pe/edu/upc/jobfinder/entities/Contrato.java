package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;
    @Column(name = "endDate", nullable = false)
    private LocalDate endDate;
    @Column(name = "salary", nullable = false)
    private Double salary;
    @Column(name = "contractType", nullable = false, length = 100)
    private String contractType;

    @OneToOne
    @JoinColumn(name = "idUsuarios")
    private Usuario usuarios;
    @OneToOne
    @JoinColumn(name = "idPostulacion")
    private Postulacion postulacion;
    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;
}
