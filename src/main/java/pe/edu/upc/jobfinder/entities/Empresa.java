package pe.edu.upc.jobfinder.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpresa;
    @Column(name = "name", nullable = false, length = 20)
    private int name;
}
